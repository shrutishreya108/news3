package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {
    private String title,description,content,image,url;
    TextView tvTitleNewsDetail,tvSubtitle,tvDescription;
    ImageView ivNewsDetailActivity;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        title = getIntent().getStringExtra("title");
        description = getIntent().getStringExtra("description");
        content = getIntent().getStringExtra("content");
        image = getIntent().getStringExtra("image");
        url = getIntent().getStringExtra("url");
        tvTitleNewsDetail = findViewById(R.id.tvNewsDetail);
        tvSubtitle = findViewById(R.id.SubDescriptionNewsDetail);
        tvDescription = findViewById(R.id.contentNewsDetail);
        ivNewsDetailActivity = findViewById(R.id.imageviewNewsDetail);
        button = findViewById(R.id.button);
        tvTitleNewsDetail.setText(title);
        tvSubtitle.setText(description);
        tvDescription.setText(content);
        Picasso.get().load(image).into(ivNewsDetailActivity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}