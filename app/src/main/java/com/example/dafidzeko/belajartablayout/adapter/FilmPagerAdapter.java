package com.example.dafidzeko.belajartablayout.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.ImageSpan;

import com.example.dafidzeko.belajartablayout.R;
import com.example.dafidzeko.belajartablayout.fragment.PlayFragment;
import com.example.dafidzeko.belajartablayout.fragment.PopularFragment;
import com.example.dafidzeko.belajartablayout.fragment.TerbaruFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dafidzeko on 28/11/16.
 */

public class FilmPagerAdapter extends FragmentStatePagerAdapter {

    private Context context;


    //untuk text
    private String[] namaFragment = {"Play", "Popular", "Terbaru"};


    //untuk icon
    private int[] gambarTes = {
            R.drawable.ic_play,
            R.drawable.ic_popular,
            R.drawable.ic_new};


    public FilmPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:

                PlayFragment playFragment = new PlayFragment();
                return playFragment;
            case 1:
                PopularFragment popularFragment = new PopularFragment();
                return popularFragment;
            case 2:
                TerbaruFragment terbaruFragment = new TerbaruFragment();
                return terbaruFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {

        /*

        jika ingin text bisa menggunakan array dari namaFragment.lenght;

        jika ingin membuat icon bisa menggunakan array gambar.lenght;

         */

        //  return namaFragment.length;


       return gambarTes.length;


    }

    @Override
    public CharSequence getPageTitle(int position) {
        //   return namaFragment[position];

        Drawable drawable = ContextCompat.getDrawable(context, gambarTes[position]);

        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        SpannableString spannedString = new SpannableString(" ");
        ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
        spannedString.setSpan(imageSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannedString;

    }


}
