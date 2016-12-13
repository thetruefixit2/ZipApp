package com.daniilbelevtsev.zipapp.ui.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.daniilbelevtsev.zipapp.ui.utils.FragmentID;
import com.daniilbelevtsev.zipapp.ui.view.ui.fragments.ListFragment;
import com.daniilbelevtsev.zipapp.ui.view.ui.fragments.MapFragment;

/**
 * Created by Daniil Belevtsev on 14.12.2016 0:44.
 * Project: ZipApp; Skype: pandamoni1
 */

public class PagerFragmentAdapter extends FragmentStatePagerAdapter {
    private static final int FRAGMENT_COUNT = 2;

    private final SparseArray<Fragment> instantiatedFragments = new SparseArray<>();

    private Context context;

    public PagerFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case FragmentID.FRAGMENT_LIST:
                fragment = ListFragment.newInstance();
                break;
            case FragmentID.FRAGMENT_MAP:
                fragment = MapFragment.newInstance();
                break;
            default:
                fragment = ListFragment.newInstance();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        instantiatedFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        instantiatedFragments.remove(position);
        super.destroyItem(container, position, object);
    }


    public Fragment getRegisteredFragment(final int position) {
        final Fragment fragment = instantiatedFragments.get(position);
        if (fragment != null) {
            return fragment;
        } else {
            return null;
        }
    }
}
