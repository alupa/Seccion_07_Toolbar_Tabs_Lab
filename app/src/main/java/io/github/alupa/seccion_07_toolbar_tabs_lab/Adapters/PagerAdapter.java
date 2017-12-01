package io.github.alupa.seccion_07_toolbar_tabs_lab.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import io.github.alupa.seccion_07_toolbar_tabs_lab.Fragments.FormFragment;
import io.github.alupa.seccion_07_toolbar_tabs_lab.Fragments.ListFragment;

/**
 * Created by Alvaro on 26-10-2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public PagerAdapter(FragmentManager fm, Context context, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FormFragment();
            case 1:
                return new ListFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
