package kenice.com.timely;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import kenice.com.timely.Extras.SettingsBuddy;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainMenuFragment";
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private TextView drawer;
    private TextView upcomingExams;
    private View headerView;
    private NavigationView navigationView;
    private boolean firstTimeRun;
    private SettingsBuddy buddy;
    private String DEFAULT = "N/A";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Timely");
        buddy= new SettingsBuddy(this);
        firstTimeRun = buddy.isFirstTimeRun();
        if (firstTimeRun)
        {
            Intent intent = new Intent(getApplicationContext(), FirstTimeRun.class);
            startActivity(intent);

        }

        FragmentManager fm = getSupportFragmentManager();

        String user = buddy.getFullName();

        //Set Drawer Header
        navigationView = (NavigationView) findViewById(R.id.navView);
        // Find our drawer view
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        setupDrawerContent(navigationView);
        headerView = LayoutInflater.from(this).inflate(R.layout.user_info, navigationView, false);
        navigationView.addHeaderView(headerView);
        drawer = (TextView) headerView.findViewById(R.id.currentUser);
        upcomingExams = (TextView) headerView.findViewById(R.id.numberOfExams);


        drawerToggle = setupDrawerToggle();

        // Tie DrawerLayout events to the ActionBarToggle
        drawerLayout.addDrawerListener(drawerToggle);

        drawer.setText(user);

        MainMenuFragment fragment = new MainMenuFragment();


        fm.beginTransaction().add(R.id.fragmentHolder, fragment, "MainMenuFragment").commit();


    }

    private ActionBarDrawerToggle setupDrawerToggle()
    {
        return new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer);
    }


    // `onPostCreate` called when activity start-up is complete after `onStart()`
    // NOTE! Make sure to override the method with only a single `Bundle` argument
    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();

    }

    private void setupDrawerContent(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener()
                {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem)
                    {
                        Log.d(TAG, "Going to home");
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);

        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    public void selectDrawerItem(MenuItem menuItem)
    {
        // Create a new fragment and specify the planet to show based on position

        Fragment fragmentA = null;
        Fragment fragmentB = null;

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();


        String fragmentClass;
        switch (menuItem.getItemId())
        {
            case R.id.nav_mainmenuFragment:
                fragmentClass = "Home";
                break;
//            case R.id.nav_customerListFragment:
//                fragmentClass = "Start deliveries";
//                break;
//            case R.id.nav_OutputDatabase:
//                fragmentClass = "Backup";
//                break;
//
//            case R.id.nav_SyncData:
//                fragmentClass = "Sync data";
//                break;
//
//            case R.id.nav_Logout:
//                fragmentClass = "Logout";
//                break;

            default:
                fragmentClass = "Home";
        }

        try
        {
            Log.d(TAG, fragmentClass);
            if (fragmentClass.equals("Home"))
            {
                MainMenuFragment mainMenuFragment = new MainMenuFragment();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragmentHolder, mainMenuFragment, "MainMenuFragment");
                fragmentTransaction.commit();

            }


//            else if (fragmentClass.equals("Backup"))
//            {
//                try
//                {
//                    String MEDIA_MOUNTED = "mounted";
//                    String diskState = Environment.getExternalStorageState();
//                    if (diskState.equals(MEDIA_MOUNTED))
//                    {
//                        File sd = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//                        File data = Environment.getDataDirectory();
//
//
//                        String currentDBPath = getString(R.string.app_database_path);
//                        String backupDBPath = "courier_backup.db";
//                        File currentDB = new File(currentDBPath);
//                        File backupDB = new File(sd, backupDBPath);
//
//                        if (currentDB.exists())
//                        {
//                            FileChannel src = new FileInputStream(currentDB).getChannel();
//                            FileChannel dst = new FileOutputStream(backupDB).getChannel();
//                            dst.transferFrom(src, 0, src.size());
//                            src.close();
//                            dst.close();
//                        }
//                    }
//
//
//                } catch (Exception e) {
//
//                }
//            }
//            else if (fragmentClass.equals("Sync data"))
//            {
//                Intent intent = new Intent(this, SyncDataActivity.class);
//                startActivity(intent);
//
//
//            }
//            else if (fragmentClass.equals("Logout"))
//            {
//                logoutUser();
//            }
//            else
//            {
//                fragmentA = new CustomerListFragment();
//                fragmentB = new CustomerLocationFragment();
//                if (!isDualPane)
//                {
//                    // We are in a single pane layout
//                    getSupportFragmentManager().beginTransaction().replace(R.id.masterSinglePane, fragmentA, "CustomerListFragment").addToBackStack("CustomerListFragment").commit();
//                }
//
//                else if (isDualPane)
//                {
//                    getSupportFragmentManager().beginTransaction().replace(R.id.master, fragmentA, "CustomerListFragment").commit();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.detail, fragmentB, "CustomerLocationFragment").commit();
//                }
//
//
//                fragmentManager.beginTransaction().replace(R.id.master, fragmentA).commit();
//                fragmentManager.beginTransaction().replace(R.id.detail, fragmentB).commit();
//            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        drawerLayout.closeDrawers();
    }
}
