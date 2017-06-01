package com.example.shaymaa.disegnnew;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import static android.view.Gravity.LEFT;
import static android.view.Gravity.RIGHT;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout = null;
    SearchView sv;
    private GridLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

//        dynamicToolbarColor();

//        toolbarTextAppernce();



        lLayout = new GridLayoutManager(MainActivity.this, 3);

        sv= (SearchView) findViewById(R.id.mSearch);
        sv.setGravity(LEFT);


         RecyclerView rv= (RecyclerView) findViewById(R.id.myRecycler);
        //SET ITS PROPETRIES
        rv.setHasFixedSize(true);
        rv.setLayoutManager(  new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv.setItemAnimator(new DefaultItemAnimator());


        final SectionListDataAdapter adapterr= new SectionListDataAdapter(this,getNames());

        //ADAPTER
        final MyAdapter adapter=new MyAdapter(this,getPlayers());
        rv.setAdapter(adapterr);

        RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);

        my_recycler_view.setHasFixedSize(true);


        my_recycler_view.setLayoutManager(lLayout);

        my_recycler_view.setAdapter(adapter);



        //SEARCH
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE
                adapter.getFilter().filter(query);
                return false;
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //ADD PLAYERS TO ARRAYLIST
    private ArrayList<Player> getPlayers()
    {
        ArrayList<Player> players=new ArrayList<>();
        Player p=new Player();
        p.setName("Ander Herera");
        p.setPos("Midfielder");
        p.setImg(R.drawable. girla);
        players.add(p);
        p=new Player();
        p.setName("David De Geaa");
        p.setPos("34");
        p.setImg(R.drawable. girlb);
        players.add(p);
        p=new Player();
        p.setName("Michael Carrick");
        p.setPos("45");
        p.setImg(R.drawable. girlc);
        players.add(p);
        p=new Player();
        p.setName("Juan Mata");
        p.setPos("67");
        p.setImg(R.drawable. girld);
        players.add(p);
        p=new Player();
        p.setName("Diego Costa");
        p.setPos("77");
        p.setImg(R.drawable.girle);
        players.add(p);
        p=new Player();
        p.setName("Oscar");
        p.setPos("56");
        p.setImg(R.drawable.girlf);
        players.add(p);
        return players;
    }





    //ADD PLAYERS TO ARRAYLIST
    private ArrayList<SingleItemModel> getNames()
    {
        ArrayList<SingleItemModel>  names =new ArrayList<>();
        SingleItemModel p=new SingleItemModel();
        p.setName("مشروبات ");
        p.setImg(R.drawable.peach);
        names.add(p);
        SingleItemModel n=new SingleItemModel();
        n.setName("خضروات");
        n.setImg(R.drawable.peach);
        names.add(n);

        SingleItemModel k=new SingleItemModel();
         k.setName("فاكهه");
        k.setImg(R.drawable.peach);
        names.add(k);

        SingleItemModel m=new SingleItemModel();
        m.setName("مشروبات");
        m.setImg(R.drawable.peach);
        names.add(m);

        SingleItemModel mm=new SingleItemModel();
        mm.setName("طازج");
        mm.setImg(R.drawable.peach);
        names.add(mm);

        return  names;
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
             super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
