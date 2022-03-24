package com.example.pets.ui.fragment;


import static com.amap.api.location.AMapLocationClient.setApiKey;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.example.pets.R;
import com.example.pets.base.baseFragment;
import com.example.pets.ui.activity.CheckActivity;
import com.example.pets.ui.adapter.CheckSmallAdapter;

import androidx.appcompat.app.AlertDialog;
import androidx.viewpager.widget.ViewPager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;


public class fragmentCheck extends baseFragment implements CheckSmallAdapter.CheckItemClickListener{
    private static final String TAG = "fragmentCheck";
    //获取地图控件引用
    @BindView(R.id.map)
    MapView mMapView = null;
    private UiSettings muisettings;

    @BindView(R.id.check_search_bar)
    EditText searchbar = null;

    @BindView(R.id.check_search_icon)
    ImageButton searchButton = null;

    private String mcity = null;

    private AMapLocation nowLocation = null;


    //开启定位服务
    private AMapLocationClient mapLocationClient =null;
    //定位客户端句柄属性
    private AMapLocationClientOption mapLocationClientOption = null;
    private AMap aMap;

    //显示自我位置的图标与限制重复的boolean
    private Marker mselfMarker = null;
    private boolean isAddedSelfMarker = false;



    //这里是绑定的这个页面里面的小切换视窗！
    @BindView(R.id.check_small_place_layout)
    public ViewPager checkSmallViewPager = null;

    private CheckSmallAdapter checkSmallAdapter;
    private boolean isClicked = false;

    @Override
    protected int getRootViewResId() {
        Log.d(TAG,"getView!");
        return R.layout.fragment_check;
    }

    @Override
    protected void initView(View view) {
        setApiKey("8a48b12ba838220448e2eeeebb693589");
        Context context = getContext();
        if (context != null) {
            new AlertDialog.Builder(context).setTitle("提示")
                    .setMessage("您同意用户协议并授权软件获取位置信息").setPositiveButton("確定",null)
                    .setNegativeButton("取消",null).show();
        }

        AMapLocationClient.updatePrivacyShow(context, true, true);
        AMapLocationClient.updatePrivacyAgree(context, true);
        mMapView.onCreate(this.savedInstanceState);

        aMap = null;
        if (aMap == null) {
            aMap = mMapView.getMap();
        }
        doLocation();
        doSearchPOI();
        setUpState(State.SUCCESS);
        Log.d(TAG,"------------------------here I am!----------------------------");



        //绑定adapter
        checkSmallAdapter = new CheckSmallAdapter();

        checkSmallAdapter.setOnCheckItemClickListener(this);
    }

    private void doSearchPOI() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String poistring = searchbar.getText().toString();

                //1.创建搜索条件对象
                PoiSearch.Query query = new PoiSearch.Query(poistring,"090700","0551");
                //2.创建一个POISearch句柄关联query
                try {
                    PoiSearch poiSearch = new PoiSearch(getContext(),query);
                    poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener() {
                        @Override
                        public void onPoiSearched(PoiResult poiResult, int i) {
                            //处理返回的结果
                            if(i==1000){
                                List<PoiItem> poiItemList = poiResult.getPois();
                                List<Marker> markers = new ArrayList<>();
                                double latitude1=0;
                                double longitude1=0;
                                for(int idx=0;idx<poiItemList.size();idx++){
                                    PoiItem poiItem = poiItemList.get(idx);
                                    Log.d(TAG,poiItem.getPoiId()+poiItem.getAdName()+poiItem.getDirection()+poiItem.getBusinessArea());//看看poi数据的id


                                    Marker ItemMaker = addMarkerForSelected(poiItem.getLatLonPoint().getLatitude(), poiItem.getLatLonPoint().getLongitude());
                                    markers.add(ItemMaker);

                                    Log.d(TAG,"RIGHT OVER HERE 0");
                                    doBindMarkerClick(markers);
                                    latitude1+=poiItem.getLatLonPoint().getLatitude();
                                    longitude1+=poiItem.getLatLonPoint().getLongitude();
                                }
                                LatLng latLng = new LatLng(latitude1/poiItemList.size(),longitude1/poiItemList.size());
                                aMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, Float.parseFloat("11")));//当前我地图的缩放比例
                            }else{
                                Log.e(TAG,"request failed,error code:"+i);
                                return;
                            }

                        }

                        @Override
                        public void onPoiItemSearched(PoiItem poiItem, int i) {

                        }
                    });
                    poiSearch.searchPOIAsyn();
                } catch (AMapException e) {
                    e.printStackTrace();
                }
                //3.search绑定回调函数

            }
        });

    }

    private Marker addMarkerForSelected(double latitude, double longitude) {
        Marker marker = aMap.addMarker(new MarkerOptions().position(new LatLng(latitude,longitude))
                .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.check_selected_surrounding))));
        Log.d(TAG,mselfMarker.getId());
        return marker;
    }

    private void doBindMarkerClick(List<Marker> poiItemList) {
        aMap.addOnMarkerClickListener(new AMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(!isClicked){
                    checkSmallViewPager.setAdapter(checkSmallAdapter);
                    isClicked = true;
                }
                checkSmallViewPager.setCurrentItem(1);
                Log.d(TAG,"RIGHT OVER HERE");
                return false;
            }
        });
    }
    //        aMap.addOnMapClickListener(new AMap.OnMapClickListener() {
    //            @Override
    //            public void onMapClick(LatLng latLng) {
    //                checkSmallViewPager.setAdapter(null);
    //
    //            }
    //        });


    protected void movemap(double latitude,double longtitude){
        LatLng latLng = new LatLng(latitude,longtitude);
        aMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, aMap.getCameraPosition().zoom));//当前我地图的缩放比例

    }
    private void doLocation() {
        //设置listener
        try {
            mapLocationClient = new AMapLocationClient(getContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mapLocationClientOption = new AMapLocationClientOption();
        mapLocationClientOption.setOnceLocation(true);  //代表打开地图我只看一次，就是看周围的。不是边走边看。
        mapLocationClient.setLocationOption(mapLocationClientOption);


        mapLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                   //服务器给客户端返回数据，调用的回调函数。这个就是返回的数据。判断它是否空。
                if(aMapLocation!=null){
                    if (aMapLocation.getErrorCode()==0) {
                        Log.w("Amap","location succeeded address="+aMapLocation.getAddress());
                        //定位成功就加一个自己位置的marker
                        if(!isAddedSelfMarker){
                            addMarker(aMapLocation.getLatitude(),aMapLocation.getLongitude());
                            isAddedSelfMarker = true;
                            movemap(aMapLocation.getLatitude(),aMapLocation.getLongitude());
                        }
                        mcity = aMapLocation.getCity();
                        nowLocation = aMapLocation;

                    }else{
                        Log.e("AmapError","location Error, ErrCode:"
                                + aMapLocation.getErrorCode() + ", errInfo:"
                                + aMapLocation.getErrorInfo());
                    }
                    }
                }
        });
        mapLocationClient.startLocation();
    }


    //向自己的经纬度添加一个标记
    protected void addMarker(double latitude,double longitude){
        mselfMarker = aMap.addMarker(new MarkerOptions().position(new LatLng(latitude,longitude))
        .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.check_1))));
        Log.d(TAG,mselfMarker.getId());

    }

    @Override
    protected void release() {
        if(mMapView!=null)
        mMapView.onDestroy();

    }
    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
        this.savedInstanceState = outState;
    }


    @Override
    public void onCheckItemClick() {
        startActivity(new Intent(getContext(), CheckActivity.class));
    }
}
//adb start-server