package io.github.alupa.seccion_07_toolbar_tabs_lab.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import io.github.alupa.seccion_07_toolbar_tabs_lab.Adapters.PagerAdapter;
import io.github.alupa.seccion_07_toolbar_tabs_lab.Fragments.ListFragment;
import io.github.alupa.seccion_07_toolbar_tabs_lab.Interfaces.OnPersonCreated;
import io.github.alupa.seccion_07_toolbar_tabs_lab.Models.Person;
import io.github.alupa.seccion_07_toolbar_tabs_lab.R;

public class MainActivity extends AppCompatActivity implements OnPersonCreated {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    // Índice de posición de los fragments
    public static final int FORM_FRAGMENT = 0;
    public static final int LIST_FRAGMENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolBar();
        setTabLayout();
        setViewPager();
        setTabLayoutListener();
    }

    private void setToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setTabLayout(){
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_title_first)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_title_second)));
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);
    }

    private void setViewPager(){
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void setTabLayoutListener(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void createPerson(Person person) {
        ListFragment fragment = (ListFragment) getSupportFragmentManager().getFragments().get(LIST_FRAGMENT);
        fragment.AddPerson(person);

        viewPager.setCurrentItem(LIST_FRAGMENT);
    }
}
