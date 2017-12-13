package com.example.ztz.myjingdong.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.fragment.FaxianFragment;
import com.example.ztz.myjingdong.fragment.FenleiFragment;
import com.example.ztz.myjingdong.fragment.MyFragment;
import com.example.ztz.myjingdong.fragment.ShopCartFragment;
import com.example.ztz.myjingdong.fragment.ShouyeFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 采用show / hide切换fragment
 */
public class HomeActivity extends AppCompatActivity  {

    @BindView(R.id.framelayout)
    FrameLayout framelayout;
    @BindView(R.id.radio_btn_shouye)
    RadioButton radioBtnShouye;
    @BindView(R.id.radio_btn_fenlei)
    RadioButton radioBtnFenlei;
    @BindView(R.id.radio_btn_faxian)
    RadioButton radioBtnFaxian;
    @BindView(R.id.radio_btn_shopcart)
    RadioButton radioBtnShopcart;
    @BindView(R.id.radio_btn_my)
    RadioButton radioBtnMy;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    private int mIndex;
    private ShouyeFragment shouyeFragment;
    private FenleiFragment fenleiFragment;
    private FaxianFragment faxianFragment;
    private ShopCartFragment shopCartFragment;
    private MyFragment myFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initFragment();
    }
    private void initFragment() {

        shouyeFragment = new ShouyeFragment();
        fenleiFragment = new FenleiFragment();
        faxianFragment = new FaxianFragment();
        shopCartFragment = new ShopCartFragment();
        myFragment = new MyFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction
                .add(R.id.framelayout, shouyeFragment)
                .add(R.id.framelayout, fenleiFragment)
                .add(R.id.framelayout, faxianFragment)
                .add(R.id.framelayout, shopCartFragment)
                .add(R.id.framelayout, myFragment);

        fragmentTransaction.hide(shouyeFragment).hide(fenleiFragment).hide(faxianFragment).hide(shopCartFragment)
                .show(myFragment).commit();
    }
    @OnClick({R.id.radio_btn_shouye, R.id.radio_btn_fenlei, R.id.radio_btn_faxian, R.id.radio_btn_shopcart,R.id.radio_btn_my})
    public void onClick(View view) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()) {
            case R.id.radio_btn_shouye:
                fragmentTransaction.show(shouyeFragment);
                fragmentTransaction.hide(fenleiFragment);
                fragmentTransaction.hide(faxianFragment);
                fragmentTransaction.hide(shopCartFragment);
                fragmentTransaction.hide(myFragment);
                fragmentTransaction.commitAllowingStateLoss();
                break;
            case R.id.radio_btn_fenlei:

                 fragmentTransaction.hide(shouyeFragment);
                fragmentTransaction.show(fenleiFragment);
                fragmentTransaction.hide(faxianFragment);
                fragmentTransaction.hide(shopCartFragment);
                fragmentTransaction.hide(myFragment);
                fragmentTransaction.commitAllowingStateLoss();
                break;
            case R.id.radio_btn_faxian:

                fragmentTransaction.hide(shouyeFragment);
                fragmentTransaction.hide(fenleiFragment);
                fragmentTransaction.show(faxianFragment);
                fragmentTransaction.hide(shopCartFragment);
                fragmentTransaction.hide(myFragment);
                fragmentTransaction.commitAllowingStateLoss();
                break;
            case R.id.radio_btn_shopcart:

                fragmentTransaction.hide(shouyeFragment);
                fragmentTransaction.hide(fenleiFragment);
                fragmentTransaction.hide(faxianFragment);
                fragmentTransaction.show(shopCartFragment);
                fragmentTransaction.hide(myFragment);
                fragmentTransaction.commitAllowingStateLoss();
                break;
            case R.id.radio_btn_my:

                fragmentTransaction.hide(shouyeFragment);
                fragmentTransaction.hide(fenleiFragment);
                fragmentTransaction.hide(faxianFragment);
                fragmentTransaction.hide(shopCartFragment);
                fragmentTransaction.show(myFragment);
                fragmentTransaction.commitAllowingStateLoss();
                break;
        }
    }
}
