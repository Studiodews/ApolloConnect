package app.apollobuilders.com.apollobuilders;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import app.apollobuilders.com.apollobuilders.data.javabeans2;
import app.apollobuilders.com.apollobuilders.listviewhistory.listhistory;
import app.apollobuilders.com.apollobuilders.listviewhistory.listhistoryfour;
import app.apollobuilders.com.apollobuilders.listviewhistory.listhistorythree;
import app.apollobuilders.com.apollobuilders.listviewhistory.listhistorytwo;

public class History extends AppCompatActivity {

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
    static Fragmentfirst fragmentf;
    static Fragmentsecond fragments;
    static Fragmentthird fragmentt;
    static Fragmentfourth fragmentfo;




    static ListView ll;


    static ArrayList<String> Date1=new ArrayList<String>();
    static ArrayList<String> Date2=new ArrayList<String>();
    static ArrayList<String> Date3=new ArrayList<String>();
    static ArrayList<String> Date4=new ArrayList<String>();

    static ArrayList<String> Subject1=new ArrayList<String>();
    static ArrayList<String> Subject2=new ArrayList<String>();
    static ArrayList<String> Subject3=new ArrayList<String>();
    static ArrayList<String> Subject4=new ArrayList<String>();

    TabLayout tabLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        javabeans2 jb=new javabeans2();
        Date1=jb.getDate1();
        Date2=jb.getDate2();
        Date3=jb.getDate3();
        Date4=jb.getDate4();

        Subject1=jb.getSubject1();
        Subject2=jb.getSubject2();
        Subject3=jb.getSubject3();
        Subject4=jb.getSubject4();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);


        tabLayout.setupWithViewPager(mViewPager);



    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class Fragmentfirst extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        String date[]={"11","12","13","14","15"};
        String subject[]={"hello","world","how","are","you"};


        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragmentfirst() {



        }


        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragmentfirst newInstance(int sectionNumber) {
             fragmentf = new Fragmentfirst();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragmentf.setArguments(args);
            return fragmentf;


        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 final Bundle savedInstanceState) {


            View rootView = inflater.inflate(R.layout.fragment_issue, container, false);
            ll=(ListView)rootView.findViewById(R.id.listView1);
            listhistory lh=new listhistory(this.getActivity(),Date1, Subject1);
            ll.setAdapter(lh);

            ll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i=new Intent(getContext(),HisDisplay.class);
                    i.putExtra("date",Date1.get(position));
                    i.putExtra("subject",Subject1.get(position));
                    i.putExtra("Type","Issue");
                    startActivity(i);

                }
            });
           return rootView;
        }
    }


    public static class Fragmentsecond extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragmentsecond() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragmentsecond newInstance(int sectionNumber) {
            fragments = new Fragmentsecond();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragments.setArguments(args);
            return fragments;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_comlpaint, container, false);
            ll=(ListView)rootView.findViewById(R.id.listView2);
            listhistorytwo ltw=new listhistorytwo(this.getActivity(),Date2,Subject2);
            ll.setAdapter(ltw);

            ll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(getContext(), HisDisplay.class);
                    i.putExtra("date", Date2.get(position));
                    i.putExtra("subject",Subject2.get(position));
                    i.putExtra("Type","Complaint");
                    startActivity(i);

                }
            });

            return rootView;
        }
    }


    public static class Fragmentthird extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        String date[]={"11","12","13","14","15"};
        String subject[]={"hello","world","how","are","you"};

        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragmentthird() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragmentthird newInstance(int sectionNumber) {
            fragmentt = new Fragmentthird();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragmentt.setArguments(args);
            return fragmentt;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_compliment, container, false);
            ll=(ListView)rootView.findViewById(R.id.listView3);
            listhistorythree ltr=new listhistorythree(this.getActivity(),Date3,Subject3);
            ll.setAdapter(ltr);

            ll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(getContext(), HisDisplay2.class);
                    i.putExtra("date", Date3.get(position));
                    i.putExtra("subject",Subject3.get(position));
                    i.putExtra("Type","Compliment");
                    startActivity(i);

                }
            });

            return rootView;
        }
    }


    public static class Fragmentfourth extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        String date[]={"11","12","13","14","15"};
        String subject[]={"hello","world","how","are","you"};

        private static final String ARG_SECTION_NUMBER = "section_number";

        public Fragmentfourth() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragmentfourth newInstance(int sectionNumber) {
            fragmentfo = new Fragmentfourth();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragmentfo.setArguments(args);


            return fragmentfo;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_suggestion, container, false);
            ll=(ListView)rootView.findViewById(R.id.listView4);
            listhistoryfour lf=new listhistoryfour(this.getActivity(),Date4,Subject4);
            ll.setAdapter(lf);

            ll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(getContext(), HisDisplay2.class);
                    i.putExtra("date", Date4.get(position));
                    i.putExtra("subject",Subject4.get(position));
                    i.putExtra("Type","Suggestion");
                    startActivity(i);

                }
            });

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
            switch (position+1)
            {
                case 1:

                    tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
                    return Fragmentfirst.newInstance(position + 1);

                case 2:
                    tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
                    return Fragmentsecond.newInstance(position + 1);

                case 3:
                    tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
                    return Fragmentthird.newInstance(position + 1);

                case 4:

                    tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
                    return Fragmentfourth.newInstance(position + 1);

            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }



        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Issue";
                case 1:
                    return "Complaint";
                case 2:
                    return "Compliment";
                case 3:
                    return "Suggestion";
            }
            return null;
        }
    }



    public void cancel(View view)
    {
        Date1.clear();
        Date2.clear();
        Date3.clear();
        Date4.clear();

        Subject1.clear();
        Subject2.clear();
        Subject3.clear();
        Subject4.clear();



        finish();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Date1.clear();
        Date2.clear();
        Date3.clear();
        Date4.clear();

        Subject1.clear();
        Subject2.clear();
        Subject3.clear();
        Subject4.clear();

        finish();
    }

}
