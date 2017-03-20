package com.learn.dim.nav;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    //disini kita membuat dua variabel, yaitu

    //variabel untuk memanggil drawe layout yang sudah kita buat
    private DrawerLayout mDrawerLayout;

    //dan toggle button untuk membuat burger button di drawer layout
    private ActionBarDrawerToggle mToggle;

    //tambahkan variabel untuk toolbar dihubungkan dengan layout toolbar
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //seperti biasa kita membuat inisialisasi id
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //namun dibagian toggle kita menggunakan 4 parameter, untuk context, drawerLayout dan toggle close
        // dan open yang bernilai String yang kita simpan di folder values di strings.xml
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);

        //inisialisasi toolbar
        mToolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        //terakhir membuat toggle menjadi listener untuk drawerLayout
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        //untuk membantu tambahkan support actionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
