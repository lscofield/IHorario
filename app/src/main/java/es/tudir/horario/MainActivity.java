package es.tudir.horario;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import es.tudir.horario.ui.actividades.ActivityEventos_ver_add;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager;
    Calendar calendario = Calendar.getInstance();
    int dia = calendario.get(Calendar.DAY_OF_WEEK);
    InterstitialAd mInterstitialAd;
    CountDownTimer t;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        id = getString(R.string.id_an);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(id);

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });

        tiempo();

        setToolbar(); // Añadir la toolbar

        // Setear adaptador al viewpager.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(mViewPager);

        // Preparar las pestañas
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

        tabs.setupWithViewPager(mViewPager);
}

    @Override
    protected void onResume() {
        super.onResume();

        calendario = Calendar.getInstance();
        dia = calendario.get(Calendar.DAY_OF_WEEK);
        // Setear adaptador al viewpager.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(mViewPager);

        // Preparar las pestañas
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

        tabs.setupWithViewPager(mViewPager);
        //tiempo();
    }


    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mInterstitialAd.loadAd(adRequest);
    }

    public void tiempo(){
        t = new CountDownTimer(1500, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                requestNewInterstitial();
            }

            @Override
            public void onFinish() {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
            }
        }.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        tiempo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void carga(){
        Toast.makeText(MainActivity.this, getString(R.string.carga), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_addEvento) {

            Intent i = new Intent(this, ActivityEventos_ver_add.class);
            startActivity(i);
            carga();
            return true;
        }if (id == R.id.action_sugerencias){
            Intent s = new Intent(this, Sugerencias.class);
            startActivity(s);
            return true;
        }if (id == android.R.id.home){
            tiempo();
            Log.i("", "");
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Muestra una {@link Snackbar} prefabricada
     *
     * @param msg Mensaje a proyectar
     */
    /**
     * Establece la toolbar como action bar
     */
    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.asirTituloRes);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_action_back);
            ab.setDisplayHomeAsUpEnabled(true);
        }

    }

    /**
     * Crea una instancia del view pager con los datos
     * predeterminados
     *
     * @param viewPager Nueva instancia
     */
    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());

        switch (dia){
            case 2:
                adapter.addFragment(CajaFragment.newInstance(1), getString(R.string.title_section1));
                break;
            case 3:
                adapter.addFragment(CajaFragment.newInstance(2), getString(R.string.title_section2));
                break;
            case 4:
                adapter.addFragment(CajaFragment.newInstance(3), getString(R.string.title_section3));
                break;
            case 5:
                adapter.addFragment(CajaFragment.newInstance(4), getString(R.string.title_section4));
                break;
            case 6:
                adapter.addFragment(CajaFragment.newInstance(5), getString(R.string.title_section5));
                break;
            case 7:
                adapter.addFragment(CajaFragment.newInstance(1), getString(R.string.title_section1));
                adapter.addFragment(CajaFragment.newInstance(2), getString(R.string.title_section2));
                adapter.addFragment(CajaFragment.newInstance(3), getString(R.string.title_section3));
                adapter.addFragment(CajaFragment.newInstance(4), getString(R.string.title_section4));
                adapter.addFragment(CajaFragment.newInstance(5), getString(R.string.title_section5));
                break;
            case 1:
                adapter.addFragment(CajaFragment.newInstance(1), getString(R.string.title_section1));
                adapter.addFragment(CajaFragment.newInstance(2), getString(R.string.title_section2));
                adapter.addFragment(CajaFragment.newInstance(3), getString(R.string.title_section3));
                adapter.addFragment(CajaFragment.newInstance(4), getString(R.string.title_section4));
                adapter.addFragment(CajaFragment.newInstance(5), getString(R.string.title_section5));
                break;
        }

        if (dia == 2){
            adapter.addFragment(CajaFragment.newInstance(2), getString(R.string.title_section2));
            adapter.addFragment(CajaFragment.newInstance(3), getString(R.string.title_section3));
            adapter.addFragment(CajaFragment.newInstance(4), getString(R.string.title_section4));
            adapter.addFragment(CajaFragment.newInstance(5), getString(R.string.title_section5));
        }if (dia == 3){
            adapter.addFragment(CajaFragment.newInstance(3), getString(R.string.title_section3));
            adapter.addFragment(CajaFragment.newInstance(4), getString(R.string.title_section4));
            adapter.addFragment(CajaFragment.newInstance(5), getString(R.string.title_section5));
            adapter.addFragment(CajaFragment.newInstance(1), getString(R.string.title_section1));
        }if (dia == 4){
            adapter.addFragment(CajaFragment.newInstance(4), getString(R.string.title_section4));
            adapter.addFragment(CajaFragment.newInstance(5), getString(R.string.title_section5));
            adapter.addFragment(CajaFragment.newInstance(1), getString(R.string.title_section1));
            adapter.addFragment(CajaFragment.newInstance(2), getString(R.string.title_section2));
        }if (dia == 5){
            adapter.addFragment(CajaFragment.newInstance(5), getString(R.string.title_section5));
            adapter.addFragment(CajaFragment.newInstance(1), getString(R.string.title_section1));
            adapter.addFragment(CajaFragment.newInstance(2), getString(R.string.title_section2));
            adapter.addFragment(CajaFragment.newInstance(3), getString(R.string.title_section3));
        }if (dia == 6){
            adapter.addFragment(CajaFragment.newInstance(1), getString(R.string.title_section1));
            adapter.addFragment(CajaFragment.newInstance(2), getString(R.string.title_section2));
            adapter.addFragment(CajaFragment.newInstance(3), getString(R.string.title_section3));
            adapter.addFragment(CajaFragment.newInstance(4), getString(R.string.title_section4));
        }
        viewPager.setAdapter(adapter);
    }

    /**
     * Método onClick() del FAB
     *
     * @param v View presionado
     * @param i
     */

    /**
     * Un {@link FragmentPagerAdapter} que gestiona las secciones, fragmentos y
     * títulos de las pestañas
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

}
