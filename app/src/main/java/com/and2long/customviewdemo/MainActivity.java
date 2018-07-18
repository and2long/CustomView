package com.and2long.customviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.and2long.customview.ItemView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout llContanier = findViewById(R.id.llContanier);

        ItemView itemView = new ItemView(this)
                .setItemHeight(65)                             //控件整体高度
                .setTextLeft("安卓开发者AndroidDeveloper")                              //左侧文字
                .setTextRight("卓")                             //右侧文字
                .setHintTextRight("hint")                       //右侧隐藏文字
                .setTextSizeLeft(20)                            //左侧文字大小
                .setTextSizeRight(20)                           //右测文字大小
                .setTextColorLeft(Color.BLUE)                   //左侧文字颜色
                .setTextColorRight(Color.GREEN)                 //右侧文字颜色
                .setIconLeft(R.drawable.ic_account_circle)      //左侧图标
                .setIconRight(R.drawable.ic_arrow_forward)      //右侧图标
                .showIconLeft(true)                             //显示左侧图标
                .showIconRight(true)                            //显示右侧图标
                .setIconSizeLeft(40)                            //左侧图标大小
                .setIconSizeRight(50)                           //右侧图标大小
                .showDividerTop(false)                           //显示顶部分割线
                .showDividerBottom(true);                       //显示顶部分割线

        llContanier.addView(itemView);

    }
}
