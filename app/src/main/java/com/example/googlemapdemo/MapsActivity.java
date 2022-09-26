package com.example.googlemapdemo;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemapdemo.databinding.ActivityMapsBinding;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        List<Marker> MarkerList=new ArrayList<>();



        // Add a marker in Sydney and move the camera
        LatLng Tanger = new LatLng( 35.76102523892614, -5.840995752770797);
        LatLng Oujda = new LatLng(34.696124515160726, -1.943873166427418);
        LatLng Rabat = new LatLng( 33.97660169177982, -6.846279347857943);
        LatLng Casablanca = new LatLng( 33.576272426566725, -7.583905483198764);
        Marker mTanger;
        Marker mOujda;
        Marker mRabat;
        Marker mCasablanca;

        mTanger=mMap.addMarker(new MarkerOptions().position(Tanger).title("Tanger"));
        mTanger.setTag(0);
        MarkerList.add(mTanger);

        mOujda=mMap.addMarker(new MarkerOptions().position(Oujda).title("Oujda"));
        mOujda.setTag(0);
        MarkerList.add(mOujda);

        mRabat=mMap.addMarker(new MarkerOptions().position(Rabat).title("Rabat"));
        mRabat.setTag(0);
        MarkerList.add(mRabat);

        mCasablanca=mMap.addMarker(new MarkerOptions().position(Casablanca).title("Casablanca"));
        mCasablanca.setTag(0);
        MarkerList.add(mCasablanca);

        for (Marker m : MarkerList){
            LatLng latLng = new LatLng ( m.getPosition().latitude,m.getPosition().longitude );
            mMap.addMarker(new MarkerOptions().position(latLng));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,5));
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);



        }


    }
}