package com.and2long.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by and2long on 2018/1/12.
 * 自定义组合控件：单行选项条目。
 */

public class ItemView extends RelativeLayout {

    private Context mContext;
    private ImageView ivLeft;
    private ImageView ivRight;
    private TextView tvLeft;
    private TextView tvRight;
    private View bottomDivider;
    private RelativeLayout rlRoot;
    private View topDivider;


    public ItemView(Context context) {
        this(context, null);
    }

    public ItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public ItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.item_view, this);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ItemView, 0, 0);
        //-----------------获取预设参数----------------
        //左侧文本
        String textLeft = ta.getString(R.styleable.ItemView_text_left);
        //右侧文本
        String textRight = ta.getString(R.styleable.ItemView_text_right);
        //右侧隐藏文本
        String textHint = ta.getString(R.styleable.ItemView_text_hint);
        //左侧图标
        int iconLeft = ta.getResourceId(R.styleable.ItemView_icon_left, 0);
        //右侧图标
        int iconRight = ta.getResourceId(R.styleable.ItemView_icon_right, R.drawable.ic_chevron_right);
        //是否显示左侧图标
        boolean showLeftIcon = ta.getBoolean(R.styleable.ItemView_show_icon_left, true);
        //是否显示右侧图标
        boolean showRightIcon = ta.getBoolean(R.styleable.ItemView_show_icon_right, true);
        //是否显示顶部分割线
        boolean showTopDivider = ta.getBoolean(R.styleable.ItemView_show_divider_top, false);
        //是否显示底部分割线
        boolean showBottomDivider = ta.getBoolean(R.styleable.ItemView_show_divider_bottom, true);
        //左侧文本字体大小
        float leftTextDimension = ta.getDimension(R.styleable.ItemView_text_size_left, DpUtils.dip2px(context, 14));
        //右侧字体大小
        float rightTextDimension = ta.getDimension(R.styleable.ItemView_text_size_right, DpUtils.dip2px(context, 14));
        //左侧文字颜色
        int leftTextColor = ta.getColor(R.styleable.ItemView_text_color_left, context.getResources().getColor(R.color.text_primary));
        //右侧文本颜色
        int rightTextColor = ta.getColor(R.styleable.ItemView_text_color_right, context.getResources().getColor(R.color.text_primary));
        //整体高度
        float itemHeight = ta.getDimension(R.styleable.ItemView_item_height, DpUtils.dip2px(context, 50));
        //左侧图标大小
        float iconSizeLeft = ta.getDimension(R.styleable.ItemView_icon_size_left, DpUtils.dip2px(context, 24));
        //右侧图标大小
        float iconSizeRight = ta.getDimension(R.styleable.ItemView_icon_size_right, DpUtils.dip2px(context, 24));

        ta.recycle();

        ivLeft = findViewById(R.id.iv_left);
        ivRight = findViewById(R.id.iv_right);
        tvLeft = findViewById(R.id.tv_left);
        tvRight = findViewById(R.id.tv_right);
        bottomDivider = findViewById(R.id.bottomDivider);
        topDivider = findViewById(R.id.topDivider);
        rlRoot = findViewById(R.id.rl_root);

        //设置整体高度
        ViewGroup.LayoutParams params = rlRoot.getLayoutParams();
        params.height = (int) itemHeight;
        //设置图标
        ivLeft.setImageResource(iconLeft);
        ivRight.setImageResource(iconRight);
        //设置图标大小
        ViewGroup.LayoutParams iconLeftParams = ivLeft.getLayoutParams();
        iconLeftParams.width = (int) iconSizeLeft;
        iconLeftParams.height = (int) iconSizeLeft;
        ViewGroup.LayoutParams iconRightParams = ivRight.getLayoutParams();
        iconRightParams.width = (int) iconSizeRight;
        iconRightParams.height = (int) iconSizeRight;
        //设置文字
        tvLeft.setText(textLeft);
        tvRight.setText(textRight);
        tvRight.setHint(textHint);
        //设置字体大小
        tvLeft.setTextSize(TypedValue.COMPLEX_UNIT_PX, leftTextDimension);
        tvRight.setTextSize(TypedValue.COMPLEX_UNIT_PX, rightTextDimension);
        //设置字体颜色
        tvLeft.setTextColor(leftTextColor);
        tvRight.setTextColor(rightTextColor);
        //设置显示左侧图标
        if (!showLeftIcon) {
            ivLeft.setVisibility(GONE);
        } else {
            ivLeft.setVisibility(VISIBLE);
        }
        //这只显示右侧图标
        if (!showRightIcon) {
            ivRight.setVisibility(GONE);
        } else {
            ivRight.setVisibility(VISIBLE);
        }
        //设置显示底部分割线
        if (!showBottomDivider) {
            bottomDivider.setVisibility(GONE);
        } else {
            bottomDivider.setVisibility(VISIBLE);
        }
        //设置显示顶部分割线
        if (!showTopDivider) {
            topDivider.setVisibility(GONE);
        } else {
            topDivider.setVisibility(VISIBLE);
        }
    }

    /**
     * 设置左侧文本
     *
     * @param str 文本
     * @return this
     */
    public ItemView setTextLeft(String str) {
        tvLeft.setText(str);
        return this;
    }

    /**
     * 获取左侧文本
     *
     * @return 文本
     */
    public String getTextLeft() {
        return tvLeft.getText().toString().trim();
    }

    /**
     * 设置右侧文本
     *
     * @param str 文本
     * @return this
     */
    public ItemView setTextRight(String str) {
        tvRight.setText(str);
        return this;
    }

    /**
     * 获取右侧文本
     *
     * @return 文本
     */
    public String getTextRight() {
        return tvRight.getText().toString().trim();
    }

    /**
     * 设置右侧隐藏文本
     *
     * @param str 文本
     * @return this
     */
    public ItemView setHintTextRight(String str) {
        tvRight.setHint(str);
        return this;
    }

    /**
     * 获取右侧隐藏文本
     *
     * @return 文本
     */
    public String getHintTextRight() {
        return tvRight.getHint().toString().trim();
    }


    /**
     * 设置是否显示左侧图标
     *
     * @param isShow 参数
     * @return this
     */
    public ItemView showIconLeft(boolean isShow) {
        if (isShow) {
            ivLeft.setVisibility(VISIBLE);
        } else {
            ivLeft.setVisibility(GONE);
        }
        return this;
    }

    /**
     * 设置是否显示右侧图标
     *
     * @param isShow 参数
     * @return this
     */
    public ItemView showIconRight(boolean isShow) {
        if (isShow) {
            ivRight.setVisibility(VISIBLE);
        } else {
            ivRight.setVisibility(GONE);
        }
        return this;
    }

    /**
     * 设置是否显示顶部分割线
     *
     * @param isShow 参数
     * @return this
     */
    public ItemView showDividerTop(boolean isShow) {
        if (isShow) {
            topDivider.setVisibility(VISIBLE);
        } else {
            topDivider.setVisibility(GONE);
        }
        return this;
    }


    /**
     * 设置是否显示底部分割线
     *
     * @param isShow 参数
     * @return this
     */
    public ItemView showDividerBottom(boolean isShow) {
        if (isShow) {
            bottomDivider.setVisibility(VISIBLE);
        } else {
            bottomDivider.setVisibility(GONE);
        }
        return this;
    }

    /**
     * 设置左侧文字大小
     *
     * @param size 大小
     * @return this
     */
    public ItemView setTextSizeLeft(float size) {
        tvLeft.setTextSize(size);
        return this;
    }

    /**
     * 设置右侧文字大小
     *
     * @param size 大小
     * @return this
     */
    public ItemView setTextSizeRight(float size) {
        tvRight.setTextSize(size);
        return this;
    }

    /**
     * 设置左侧文本颜色
     *
     * @param color 颜色
     * @return this
     */
    public ItemView setTextColorLeft(int color) {
        tvLeft.setTextColor(color);
        return this;
    }

    /**
     * 设置右侧文本颜色
     *
     * @param color 颜色
     * @return this
     */
    public ItemView setTextColorRight(int color) {
        tvRight.setTextColor(color);
        return this;
    }

    /**
     * 设置整体高度
     *
     * @param size 高度值
     * @return this
     */
    public ItemView setItemHeight(int size) {
        ViewGroup.LayoutParams params = rlRoot.getLayoutParams();
        params.height = DpUtils.dip2px(mContext, size);
        return this;
    }

    /**
     * 设置左边图标
     *
     * @param resId 图标资源
     * @return this
     */
    public ItemView setIconLeft(int resId) {
        ivLeft.setImageResource(resId);
        return this;
    }

    /**
     * 设置右边图标
     *
     * @param resId 图标资源
     * @return this
     */
    public ItemView setIconRight(int resId) {
        ivRight.setImageResource(resId);
        return this;
    }

    /**
     * 设置左侧图标大小
     *
     * @param size 大小
     * @return this
     */
    public ItemView setIconSizeLeft(int size) {
        ViewGroup.LayoutParams params = ivLeft.getLayoutParams();
        params.width = DpUtils.dip2px(mContext, size);
        params.height = DpUtils.dip2px(mContext, size);
        return this;
    }

    /**
     * 设置右侧图标大小
     *
     * @param size 大小
     * @return this
     */
    public ItemView setIconSizeRight(int size) {
        ViewGroup.LayoutParams params = ivRight.getLayoutParams();
        params.width = DpUtils.dip2px(mContext, size);
        params.height = DpUtils.dip2px(mContext, size);
        return this;
    }
}
