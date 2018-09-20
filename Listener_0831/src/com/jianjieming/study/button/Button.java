package com.jianjieming.study.button;

/**
 * @author 铭
 * DATE: 18/8/31 上午10:57
 */

// 主题
public class Button {

    // 相当于 List<Observer>
    private OnClickListener onClickListener;

    public void performClick() {
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    // 就相当与add(Observer o)方法
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    // 观察者 Observer
    public interface OnClickListener {
        void onClick(Button btn);
    }

}
