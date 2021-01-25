package com.example.projectandroid

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.view.*
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.checkSelfPermission
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*
import java.io.IOException



class MapsActivity : FragmentActivity(), OnMapReadyCallback,
    GoogleMap.OnMarkerClickListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private lateinit var nMap: GoogleMap
    internal var mGoogleApiClient: GoogleApiClient? = null
    internal lateinit var mLocationRequest: LocationRequest

    companion object {
        private val MY_PERMISSION_FINE_LOCATION = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val listt = findViewById<ImageButton>(R.id.btn_list)
        listt.setOnClickListener{
            val intent1 = Intent(this, ListRsActivity::class.java)
            startActivity(intent1)
        }

        val dettl = findViewById<ImageButton>(R.id.btn_about)
        dettl.setOnClickListener{
            val intent1 = Intent(this, Tentang::class.java)
            startActivity(intent1)
        }

        val btn_cari = findViewById(R.id.btn_cari) as Button

        btn_cari.setOnClickListener {
            val lokasi: String = input_lokasi.text.toString()
            var listAlamat: List<Address>? = null

            if (lokasi == "") {
                Toast.makeText(
                    this, "Masukkan lokasi yang ingin anda Cari",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val geocoder = Geocoder(this)
                try {
                    listAlamat = geocoder.getFromLocationName(lokasi, 1)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                val alamat = listAlamat!![0]
                val latLng = LatLng(alamat.latitude, alamat.longitude)
                nMap.addMarker(MarkerOptions().position(latLng).title(lokasi))
                nMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15F))
                Toast.makeText(
                    this, alamat.latitude.toString() + " " +
                            alamat.longitude.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }

    protected fun buildGoogleApiClient() {
        mGoogleApiClient = GoogleApiClient.Builder(this)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .addApi(LocationServices.API).build()
        mGoogleApiClient!!.connect()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        nMap = googleMap

        // Add a marker in Sydney and move the camera
        val petalabumi = LatLng(0.529354, 101.456634)
        val zainab = LatLng(0.513705, 101.454617)
        val andini = LatLng(0.502968, 101.428805)
        val santamar = LatLng(0.527665, 101.442233)
        val tabrani = LatLng(0.508345, 101.449922)
        val mediacalcen = LatLng(0.509105, 101.462440)
        val lancang = LatLng(0.512701, 101.464863)
        val ibnusina = LatLng(0.525720, 101.436726)
        val awalbros = LatLng(0.496621, 101.456290)
        val awalbross = LatLng(0.520947, 101.443451)
        val ekahos = LatLng(0.482275, 101.419685)
        val arifin = LatLng(0.523479, 101.451874)
        val eriabunda = LatLng(0.512256, 101.438104)
        val syafira = LatLng(0.498404, 101.454744)
        val sansani = LatLng(0.455284, 101.418607)
        val prima = LatLng(0.496697, 101.400465)
        val tampan = LatLng(0.464826, 101.382284)
        val annisa = LatLng(0.499445, 101.445012)
        val awalbrosss = LatLng(0.463265, 101.390343)
        val aulia = LatLng(0.463266, 101.385113)
        val mata = LatLng(0.476178, 101.418646)
        val budhi = LatLng(0.476699, 101.418942)

        nMap.addMarker(
            MarkerOptions().position(petalabumi).title("RSUD Petala Bumi")
                .snippet("Jl. Dr. Sutomo No.65")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(petalabumi, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(zainab).title("RSIA Zainab").snippet("Jl. Ronggo Warsito No.1")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(zainab, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(andini).title("RSIA Andini")
                .snippet("Jl. Tuanku Tambusai No.55")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(andini, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(santamar).title("RS Santa Maria Pekanbaru")
                .snippet("Jl. Jend.Ahmad Yani No.68")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(santamar, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(tabrani).title("RS Prof. Dr. Tabrani")
                .snippet("Jl. Jend. Sudirman No.410")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tabrani, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(mediacalcen).title("RS Pekanbaru Medical Center")
                .snippet("Jl. Lembaga Permasyarakatan No.25")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mediacalcen, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(lancang).title("RS Lancang Kuning")
                .snippet("Jl. Ronggo Warsito Ujung No. 5A")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lancang, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(ibnusina).title("RS Islam Ibnu Sina Pekanbaru")
                .snippet("Jl. Melati No.60")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ibnusina, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(awalbros).title("RS Awal Bros Chevron Pekanbaru")
                .snippet("Jl. Jend.Sudirman")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(awalbros, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(awalbross).title("RS Awal Bros A.Yani Pekanbaru")
                .snippet("Jl. Jend. Ahmad Yani No.73")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(awalbross, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(ekahos).title("Eka Hospital Pekanbaru")
                .snippet("Jl. Mangga Suka Jadi No.KM")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ekahos, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(arifin).title("RSUD Arifin Achmad")
                .snippet("Jl. Diponegoro No.2")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arifin, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(eriabunda).title("RSIA Eria Bunda")
                .snippet("Jl. KH. Ahmad Dahlan No.163")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(eriabunda, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(syafira).title("RS Syafira Pekanbaru")
                .snippet("Jl. Jend. Sudirman No.134")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(syafira, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(sansani).title("RS Sansani")
                .snippet("Jl. Soekarno - Hatta No. 501")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sansani, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(prima).title("RS Prima Pekanbaru").snippet("Jl. Bima No.1")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(prima, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(tampan).title("RS Jiwa Tampan")
                .snippet("Jl. HR. Soebrantas Paman No KM 12.5")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tampan, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(annisa).title("RS Annisa Pekanbaru")
                .snippet("Jl. Garuda No.66")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(annisa, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(awalbrosss).title("RS Awal Bros Panam")
                .snippet("Jl. HR. Soebrantas Panam No.88")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(awalbrosss, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(aulia).title("RS Aulia Hospital Pekanbaru")
                .snippet("Jl. HR. Soebrantas Panam No.63")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(aulia, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true

        nMap.addMarker(
            MarkerOptions().position(mata).title("RS Mata Pekanbaru Eye Center")
                .snippet("Sidomulyo Tim")
        )
        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mata, 12F))
        nMap.uiSettings.isZoomControlsEnabled = true


        if (checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            nMap.isMyLocationEnabled = true
        }
        nMap.setOnMarkerClickListener(this)
        tambahMarkerLongClick(nMap)

        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) ==
            PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) ==
            PackageManager.PERMISSION_GRANTED
        ) {
            buildGoogleApiClient()
            nMap.isMyLocationEnabled = true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_tampilan_map, menu)
        return true
    }

    override fun onConnected(bundle: Bundle?) {
        mLocationRequest = LocationRequest()
        mLocationRequest.interval = 1000
        mLocationRequest.fastestInterval = 1000
        mLocationRequest.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) ==
            PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) ==
            PackageManager.PERMISSION_GRANTED
        ) {
            LocationServices.getFusedLocationProviderClient(this)
        }
    }

    override fun onConnectionSuspended(p0: Int) {
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.map_normal -> {
                nMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                true
            }
            R.id.map_hybrid -> {
                nMap.mapType = GoogleMap.MAP_TYPE_HYBRID
                true
            }
            R.id.map_satelit -> {
                nMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
                true
            }
            R.id.map_terrain -> {
                nMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onMarkerClick(p0: Marker?) = false

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSION_FINE_LOCATION -> if (grantResults[0] ==
                PackageManager.PERMISSION_GRANTED
            ) {
                if (checkSelfPermission(
                        this, android.Manifest.permission.ACCESS_FINE_LOCATION
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    nMap.isMyLocationEnabled = true
                }
            } else {
                Toast.makeText(
                    this, "Aplikasi ini membutuhkan izin akses lokasi",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }



    private fun getAlamat(lat: LatLng): String? {
        val geocoder = Geocoder(this)
        val list = geocoder.getFromLocation(lat.latitude, lat.longitude, 1)
        return list[0].getAddressLine(0)
    }

    fun tambahMarkerLongClick(googleMap: GoogleMap) {
        googleMap.setOnMapLongClickListener { latLng ->
            val koordinat = LatLng(latLng.latitude, latLng.longitude)
            val markerOptions = MarkerOptions().position(koordinat)
            val namaJalan = getAlamat(koordinat)
            markerOptions.title(namaJalan)

            googleMap.addMarker(
                MarkerOptions().position(koordinat).title("Marker Baru").snippet(namaJalan)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
            )
        }
    }
// val btn_cari = findViewById<Button>(R.id.btn_cari);


//        fun Detill(view: View) {}
//    val detil = findViewById<ImageButton>(R.id.btn_detil)
//    detil.setOnClickListener {
//        val intent = Intent(this, Detil::class.java)
//        startActivity(intent)
//    }
}