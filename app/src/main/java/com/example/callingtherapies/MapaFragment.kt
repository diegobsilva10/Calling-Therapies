package com.example.callingtherapies

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapaFragment : Fragment(), OnMapReadyCallback {

    private var map: GoogleMap? = null

    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap) {
        this.map = googleMap

        val location = LatLng(-23.525322 , -46.649481)

        val update = CameraUpdateFactory.newLatLngZoom(location, 18f)
        map?.moveCamera(update)

        map?.addMarker(MarkerOptions().title("CT").snippet("Calling Therapies").position(location))

        map?.mapType = GoogleMap.MAP_TYPE_NORMAL

        val ok = PermisionUtils.validate(requireActivity(),
            1, Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION)
        if (ok) map?.isMyLocationEnabled = true
    }

    @SuppressLint("MissingPermission")
    override fun  onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResult: IntArray)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResult)
        for (result in grantResult){
            if (result == PackageManager.PERMISSION_GRANTED){
                map?.isMyLocationEnabled = true
                return
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, bundle: Bundle?): View{
        val view = inflater?.inflate(R.layout.fragment_mapa, container, false)
        val mapaFragment = childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapaFragment.getMapAsync(this)
        return view
    }




}