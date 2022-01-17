package com.example.easytripplanners.Utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CNav {

    public <T extends Fragment> void showFragment(Class<T> fragmentClass){
        activity.getSupportFragmentManager()
            .beginTransaction()
            .replace(frameLayoutId,getFragment((Class<Fragment>) fragmentClass))
            .commit();
    }

    public  void showDefault(){
        showFragment(defaultFragment);
    }

    public <T extends Fragment> CNav(AppCompatActivity activity, int frameLayoutId, CNavFragment[] cNavFragments, Class<T> defaultFragment){
        this.activity = activity;
        this.cNavFragments = cNavFragments;
        this.frameLayoutId = frameLayoutId;
        this.defaultFragment = (Class<Fragment>) defaultFragment;
        showFragment(defaultFragment);
    }

    public CNav(AppCompatActivity activity, int frameLayoutId, CNavFragment[] cNavFragments){
        this.activity = activity;
        this.cNavFragments = cNavFragments;
        this.frameLayoutId = frameLayoutId;
        this.defaultFragment = (Class<Fragment>) cNavFragments[0].fragment.getClass();
        showFragment(defaultFragment);
    }

    private Fragment getFragment(Class<Fragment> fragmentClass) {
        List<Fragment> cNavFragmentList =  Arrays.stream(cNavFragments)
                .filter((CNavFragment cNav)->cNav.fragment.getClass()==fragmentClass)
                .map(CNavFragment::getFragment)
                .collect(Collectors.toList());
        return !cNavFragmentList.isEmpty() ?cNavFragmentList.get(0):null;
    }

    private final CNavFragment[] cNavFragments;
    private final AppCompatActivity activity;
    private final int frameLayoutId;
    private final Class<Fragment> defaultFragment;

    public static class CNavFragment{
        public Fragment fragment;
        boolean isSingleton;
        public CNavFragment(Fragment fragment,boolean isSingleton) {
            this.fragment = fragment;
            this.isSingleton = isSingleton;
        }

        public Fragment getFragment()  {
            try {
                if(isSingleton)
                    return fragment;
                else
                    return fragment.getClass().newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
