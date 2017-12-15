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
public class HomeActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

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
    private ShouyeFragment shouyeFragment;
    private FenleiFragment fenleiFragment;
    private FaxianFragment faxianFragment;
    private ShopCartFragment shopCartFragment;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initFragment();
        radioGroup.setOnCheckedChangeListener(this);
    }
    private void initFragment() {
        shouyeFragment = new ShouyeFragment();
        fenleiFragment = new FenleiFragment();
        faxianFragment = new FaxianFragment();
        shopCartFragment = new ShopCartFragment();
        myFragment = new MyFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.framelayout, myFragment, null).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.framelayout, fenleiFragment, null).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.framelayout, faxianFragment, null).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.framelayout, shouyeFragment, null).commit();

        getSupportFragmentManager().beginTransaction()
                .hide(shouyeFragment)
                .hide(fenleiFragment)
                .hide(faxianFragment)
                .show(myFragment)
                .commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radio_btn_shouye:
                getSupportFragmentManager().beginTransaction().show(shouyeFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(fenleiFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(faxianFragment).commit();
                getSupportFragmentManager().beginTransaction().remove(shopCartFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(myFragment).commit();
                break;
            case R.id.radio_btn_fenlei:
                getSupportFragmentManager().beginTransaction().hide(shouyeFragment).commit();
                getSupportFragmentManager().beginTransaction().show(fenleiFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(faxianFragment).commit();
                getSupportFragmentManager().beginTransaction().remove(shopCartFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(myFragment).commit();
                break;
            case R.id.radio_btn_faxian:
                getSupportFragmentManager().beginTransaction().hide(shouyeFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(fenleiFragment).commit();
                getSupportFragmentManager().beginTransaction().show(faxianFragment).commit();
                getSupportFragmentManager().beginTransaction().remove(shopCartFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(myFragment).commit();
                break;
            case R.id.radio_btn_shopcart:

                getSupportFragmentManager().beginTransaction().hide(shouyeFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(fenleiFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(faxianFragment).commit();
                getSupportFragmentManager().beginTransaction().add(R.id.framelayout,shopCartFragment).commit();
                getSupportFragmentManager().beginTransaction().show(shopCartFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(myFragment).commit();
                break;
            case R.id.radio_btn_my:
                getSupportFragmentManager().beginTransaction().hide(shouyeFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(fenleiFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(faxianFragment).commit();
                getSupportFragmentManager().beginTransaction().remove(shopCartFragment).commit();
                getSupportFragmentManager().beginTransaction().show(myFragment).commit();
                break;
        }
    }
}
