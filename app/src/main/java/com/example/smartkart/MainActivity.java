package com.example.smartkart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smartkart.Adapters.CategoryAdapter;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mCategoryRecyclerView;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.toolbar_main));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        LinearLayout headerView = (LinearLayout) navigationView.getHeaderView(0);
        de.hdodenhof.circleimageview.CircleImageView profileView =
                headerView.findViewById(R.id.profile_image);
        TextView userNameView = headerView.findViewById(R.id.login_display);
        TextView userMailView = headerView.findViewById(R.id.email);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, findViewById(R.id.toolbar_main),
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(item -> false);

        this.mCategoryRecyclerView = findViewById(R.id.category_recycler_view);
        this.categoryAdapter = new CategoryAdapter(this);
        this.mCategoryRecyclerView.setAdapter(this.categoryAdapter);
        this.mCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}