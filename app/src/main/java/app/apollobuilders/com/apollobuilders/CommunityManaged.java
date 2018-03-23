package app.apollobuilders.com.apollobuilders;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CommunityManaged extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_managed);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);



    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class Fragment1 extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragment1() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment1 newInstance(int sectionNumber) {
            Fragment1 fragment = new Fragment1();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.commfragment1, container, false);
            return rootView;
        }
    }


    public static class Fragment2 extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragment2() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment2 newInstance(int sectionNumber) {
            Fragment2 fragment = new Fragment2();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.commfragment2, container, false);
            return rootView;
        }
    }

    public static class Fragment3 extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragment3() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment3 newInstance(int sectionNumber) {
            Fragment3 fragment = new Fragment3();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.commfragment3, container, false);
            return rootView;
        }
    }


    public static class Fragment4 extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragment4() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment4 newInstance(int sectionNumber) {
            Fragment4 fragment = new Fragment4();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.commfragment4, container, false);
            return rootView;
        }
    }


    public static class Fragment5 extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragment5() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment5 newInstance(int sectionNumber) {
            Fragment5 fragment = new Fragment5();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.commfragment5, container, false);
            return rootView;
        }
    }


    public static class Fragment6 extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragment6() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment6 newInstance(int sectionNumber) {
            Fragment6 fragment = new Fragment6();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.commfragment6, container, false);
            return rootView;
        }
    }


    public static class Fragment7 extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragment7() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment7 newInstance(int sectionNumber) {
            Fragment7 fragment = new Fragment7();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.commfragment7, container, false);
            return rootView;
        }
    }




    public static class Fragment8 extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragment8() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment8 newInstance(int sectionNumber) {
            Fragment8 fragment = new Fragment8();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.commfragment8, container, false);
            return rootView;
        }
    }


    public static class Fragment9 extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragment9() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment9 newInstance(int sectionNumber) {
            Fragment9 fragment = new Fragment9();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.commfragment9, container, false);
            return rootView;
        }
    }


    public static class Fragment10 extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragment10() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment10 newInstance(int sectionNumber) {
            Fragment10 fragment = new Fragment10();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.commfragment10, container, false);
            return rootView;
        }
    }


    public static class Fragment11 extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragment11() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment11 newInstance(int sectionNumber) {
            Fragment11 fragment = new Fragment11();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.commfragment11, container, false);
            return rootView;
        }
    }


    public static class Fragment12 extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragment12() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment12 newInstance(int sectionNumber) {
            Fragment12 fragment = new Fragment12();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.commfragment12, container, false);
            return rootView;
        }
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position+1)
            {
                case 1:
                    return Fragment1.newInstance(position+1);

                case 2:
                    return Fragment2.newInstance(position+1);
                case 3:
                    return Fragment3.newInstance(position+1);
                case 4:
                    return Fragment4.newInstance(position+1);
                case 5:
                    return Fragment5.newInstance(position+1);
                case 6:
                    return Fragment6.newInstance(position+1);
                case 7:
                    return Fragment7.newInstance(position+1);
                case 8:
                    return Fragment8.newInstance(position+1);
                case 9:
                    return Fragment9.newInstance(position+1);
                case 10:
                    return Fragment10.newInstance(position+1);
                case 11:
                    return Fragment11.newInstance(position+1);
                case 12:
                    return Fragment12.newInstance(position+1);

            }

            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 12;
        }

//        @Override
//        public CharSequence getPageTitle(int position) {
//            switch (position) {
//                case 0:
//                    return "SECTION 1";
//                case 1:
//                    return "SECTION 2";
//                case 2:
//                    return "SECTION 3";
//            }
//            return null;
//        }
    }

    public void cancel(View view)
    {


        finish();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
}
