package zhaoliang.com.homenews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import zhaoliang.com.homenews.R;
import zhaoliang.com.homenews.domain.News;
import zhaoliang.com.homenews.xlistview.XListView;

public class MainActivity extends AppCompatActivity implements XListView.IXListViewListener, Callback, AdapterView.OnItemClickListener {

    private XListView newslist;
    private List<News.ResultBean> newses;
    private NewsListAdapter adapter;
    private int page = 1, rows = 10;
    private OkHttpClient client;
    private int load;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            adapter.notifyDataSetChanged();
            newslist.stopRefresh(true);
            newslist.stopLoadMore();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newslist = (XListView) findViewById(R.id.newslist);
        newslist.setPullLoadEnable(true);
        newslist.setXListViewListener(this);
        newses = new ArrayList<>();
        adapter = new NewsListAdapter();
        newslist.setAdapter(adapter);
        newslist.setOnItemClickListener(this);
        client = new OkHttpClient();
        load();
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        // 如果当前页大于1的时候加载前一页
        if (page > 1) {
            page--;
            load();
        } else {
            newslist.stopRefresh(true);
        }
    }

    /**
     * 加载更多
     */
    @Override
    public void onLoadMore() {
        page++;
        load();
    }

    public void load() {
        Request request = new Request.Builder()
                .url("http://api.avatardata.cn/GuoNeiNews/Query?key=3211c103a117444f949418b69b45ddc8&page=" + page + "&rows=" + rows)
                .build();

        client.newCall(request).enqueue(this);
    }

    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        News news = JSON.parseObject(response.body().string(), News.class);
        newses.addAll(news.getResult());
        mHandler.sendEmptyMessage(1);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, NewsDetailActivity.class);
        intent.putExtra("url", newses.get(i).getUrl());
        startActivity(intent);
    }

    /**
     * 新闻列表适配器
     */
    class NewsListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return newses.size();
        }

        @Override
        public News.ResultBean getItem(int i) {
            return newses.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder = null;
            if (view == null) {
                viewHolder = new ViewHolder();
                view = View.inflate(MainActivity.this, R.layout.news_item, null);
                viewHolder.icon = (SimpleDraweeView) view.findViewById(R.id.icon);
                viewHolder.tvTitle = (TextView) view.findViewById(R.id.tv_title);
                viewHolder.tvContent = (TextView) view.findViewById(R.id.tv_content);
                viewHolder.tvTime = (TextView) view.findViewById(R.id.tv_time);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            News.ResultBean item = getItem(i);
            viewHolder.icon.setImageURI(item.getPicUrl());
            viewHolder.tvTitle.setText(item.getDescription());
            viewHolder.tvContent.setText(item.getTitle());
            viewHolder.tvTime.setText(item.getCtime());
            return view;
        }

        class ViewHolder {
            SimpleDraweeView icon;
            TextView tvTitle;
            TextView tvContent;
            TextView tvTime;
        }
    }
}
