package github.vege19.popnow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import github.vege19.popnow.Fragments.MoviesFragment;
import github.vege19.popnow.Fragments.TVShowsFragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;
    private FragmentManager fragmentManager;

    //Fragments
    private Fragment moviesFragment;
    private Fragment tvshowsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.navigationView);

        //Init base navigation
        initContent();

    }

    //Init fragments and bottom navigation view functionality
    private void initContent() {

        moviesFragment = new MoviesFragment();
        tvshowsFragment = new TVShowsFragment();

        fragmentManager = getSupportFragmentManager();

        //Setting movie fragment as first to load
        fragmentManager.beginTransaction()
                .replace(R.id.navigationContainer, moviesFragment)
                .commit();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment currentFragment = null;

                //Switch to select fragments
                switch (menuItem.getItemId()) {
                    case R.id.navigation_movies:
                        currentFragment = moviesFragment;
                        break;
                    case R.id.navigation_tv:
                        currentFragment = tvshowsFragment;
                        break;
                }

                fragmentManager.beginTransaction()
                        .replace(R.id.navigationContainer, currentFragment)
                        .commit();

                return true;
            }

        });

    }

}
