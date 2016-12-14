package com.daniilbelevtsev.zipapp.ui.view.ui.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daniilbelevtsev.zipapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniil Belevtsev on 14.12.2016 0:24.
 * Project: ZipApp; Skype: pandamoni1
 */

public class ErrorView extends RelativeLayout {


    @BindView(R.id.errorImage)
    ImageView errorImage;
    @BindView(R.id.errorText)
    TextView errorText;

    public ErrorView(Context context) {
        super(context);
        init();
    }

    public ErrorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ErrorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ErrorView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        View rootView = inflate(getContext(), R.layout.view_error, this);
        ButterKnife.bind(this, rootView);
    }

    public void setErrorText(String message) {
        if (errorText != null && message != null) {
            errorText.setText(String.format("%s%s", getContext().getString(R.string.error_occurred), message));
        }
    }

    public void setErrorText(@StringRes int message) {
        if (errorText != null && message != -1) {
            errorText.setText(String.format("%s%s", getContext().getString(R.string.error_occurred), getContext().getString(message)));
        }
    }
}
