package com.fofidashboard.fragment;

/**
 * Created by prabhavathi on 3/11/17.
 */

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.fofidashboard.R;
import com.fofidashboard.activity.HorizontalScroll;
import com.fofidashboard.activity.VerticalScroll;

import java.util.ArrayList;

public class MusicFragment extends Fragment implements HorizontalScroll.ScrollViewListener, VerticalScroll.ScrollViewListener {


    ArrayList<String> timeArratlist = new ArrayList<>();
    ArrayList<String> channelNamesArratlist = new ArrayList<>();
    ArrayList<String> colorTvArraylist = new ArrayList<>();
    ArrayList<String> udayaArraylist = new ArrayList<>();
    ArrayList<String> udayaNewsArraylist = new ArrayList<>();


    int j = 0;
    int i = 0;
    int a = 1;
    int b=1;

    private static int SCREEN_HEIGHT;
    private static int SCREEN_WIDTH;
    RelativeLayout relativeLayoutMain;

    RelativeLayout relativeLayoutA;
    RelativeLayout relativeLayoutB;
    RelativeLayout relativeLayoutC;
    RelativeLayout relativeLayoutD;

    TableLayout tableLayoutA;
    TableLayout tableLayoutB;
    TableLayout tableLayoutC;
    TableLayout tableLayoutD;

    TableRow tableRow;
    TableRow tableRowB;

    HorizontalScroll horizontalScrollViewB;
    HorizontalScroll horizontalScrollViewD;

    VerticalScroll scrollViewC;
    VerticalScroll scrollViewD;

    /*
         This is for counting how many columns are added in the row.
    */
    int tableColumnCountB = 0;

    /*
         This is for counting how many row is added.
    */
    int tableRowCountC = 0;

    ImageView arrow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.music_fragment, container, false);
          /*
            Mandatory Content
         */
        relativeLayoutMain = (RelativeLayout)view.findViewById(R.id.relativeLayoutMain);



        staticValues();

        getScreenDimension();
        initializeRelativeLayout();
        initializeScrollers();
        initializeTableLayout();
        horizontalScrollViewB.setScrollViewListener(this);
        horizontalScrollViewD.setScrollViewListener(this);
        scrollViewC.setScrollViewListener(this);
        scrollViewD.setScrollViewListener(this);
        addRowToTableA();
        initializeRowForTableB();




        /*
            Till Here.
         */


        /*  There is two unused functions
            Have a look on these functions and try to recreate and use it.
            createCompleteColumn();
            createCompleteRow();
        */



        for (int k = 0; k < 48; k++) {
            addColumnsToTableB(timeArratlist.get(k), k);
        }
        for (int i = 0; i < channelNamesArratlist.size(); i++) {
            initializeRowForTableD(i);
            addRowToTableC(channelNamesArratlist.get(i));
            for (int j = 0; j < 48; j++) {
                if (i == 0 || i == 3 || i == 6 || i == 9) {

                    if (j == 1 && i == 0) {
                    } else {
                        addColumnToTableAtD(i, colorTvArraylist.get(j));

                    }

                } else if (i == 1 || i == 4 || i == 7 || i == 10) {
                    if (j == 32 && i == 1) {
                    } else {
                        addColumnToTableAtD(i, udayaNewsArraylist.get(j));

                    }
                } else if (i == 2 || i == 5 || i == 8 || i == 11) {
                    addColumnToTableAtD(i, udayaArraylist.get(j));
                } else {
                    addColumnToTableAtD(i, colorTvArraylist.get(j));
                }
            }
        }
        return view;
    }

    private void getScreenDimension() {
        WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        SCREEN_WIDTH = size.x;
        SCREEN_HEIGHT = size.y;
    }

    private void initializeRelativeLayout() {
        relativeLayoutA = new RelativeLayout(getActivity());
        relativeLayoutA.setId(R.id.relativeLayoutA);
        relativeLayoutA.setPadding(0, 0, 0, 0);

        relativeLayoutB = new RelativeLayout(getActivity());
        relativeLayoutB.setId(R.id.relativeLayoutB);
        relativeLayoutB.setPadding(0, 0, 0, 0);

        relativeLayoutC = new RelativeLayout(getActivity());
        relativeLayoutC.setId(R.id.relativeLayoutC);
        relativeLayoutC.setPadding(0, 0, 0, 0);

        relativeLayoutD = new RelativeLayout(getActivity());
        relativeLayoutD.setId(R.id.relativeLayoutD);
        relativeLayoutD.setPadding(0, 0, 0, 0);

        relativeLayoutA.setLayoutParams(new RelativeLayout.LayoutParams(SCREEN_WIDTH / 5, SCREEN_HEIGHT / 20));
        this.relativeLayoutMain.addView(relativeLayoutA);


        RelativeLayout.LayoutParams layoutParamsRelativeLayoutB = new RelativeLayout.LayoutParams(SCREEN_WIDTH - (SCREEN_WIDTH / 5), SCREEN_HEIGHT / 20);
        layoutParamsRelativeLayoutB.addRule(RelativeLayout.RIGHT_OF, R.id.relativeLayoutA);
        relativeLayoutB.setLayoutParams(layoutParamsRelativeLayoutB);
        this.relativeLayoutMain.addView(relativeLayoutB);

        RelativeLayout.LayoutParams layoutParamsRelativeLayoutC = new RelativeLayout.LayoutParams(SCREEN_WIDTH / 5, SCREEN_HEIGHT - (SCREEN_HEIGHT / 20));
        layoutParamsRelativeLayoutC.addRule(RelativeLayout.BELOW, R.id.relativeLayoutA);
        relativeLayoutC.setLayoutParams(layoutParamsRelativeLayoutC);
        this.relativeLayoutMain.addView(relativeLayoutC);

        RelativeLayout.LayoutParams layoutParamsRelativeLayoutD = new RelativeLayout.LayoutParams(SCREEN_WIDTH - (SCREEN_WIDTH / 5), SCREEN_HEIGHT - (SCREEN_HEIGHT / 20));
        layoutParamsRelativeLayoutD.addRule(RelativeLayout.BELOW, R.id.relativeLayoutB);
        layoutParamsRelativeLayoutD.addRule(RelativeLayout.RIGHT_OF, R.id.relativeLayoutC);
        relativeLayoutD.setLayoutParams(layoutParamsRelativeLayoutD);
        this.relativeLayoutMain.addView(relativeLayoutD);

    }

    private void initializeScrollers() {
        horizontalScrollViewB = new HorizontalScroll(getActivity());
        horizontalScrollViewB.setPadding(0, 0, 0, 0);

        horizontalScrollViewD = new HorizontalScroll(getActivity());
        horizontalScrollViewD.setPadding(0, 0, 0, 0);

        scrollViewC = new VerticalScroll(getActivity());
        scrollViewC.setPadding(0, 0, 0, 0);

        scrollViewD = new VerticalScroll(getActivity());
        scrollViewD.setPadding(0, 0, 0, 0);

        horizontalScrollViewB.setLayoutParams(new ViewGroup.LayoutParams(SCREEN_WIDTH - (SCREEN_WIDTH / 5), SCREEN_HEIGHT / 20));
        scrollViewC.setLayoutParams(new ViewGroup.LayoutParams(SCREEN_WIDTH / 5, SCREEN_HEIGHT - (SCREEN_HEIGHT / 20)));
        scrollViewD.setLayoutParams(new ViewGroup.LayoutParams(SCREEN_WIDTH - (SCREEN_WIDTH / 5), SCREEN_HEIGHT - (SCREEN_HEIGHT / 20)));
        horizontalScrollViewD.setLayoutParams(new ViewGroup.LayoutParams(SCREEN_WIDTH - (SCREEN_WIDTH / 5), SCREEN_HEIGHT - (SCREEN_HEIGHT / 20)));

        this.relativeLayoutB.addView(horizontalScrollViewB);
        this.relativeLayoutC.addView(scrollViewC);
        this.scrollViewD.addView(horizontalScrollViewD);
        this.relativeLayoutD.addView(scrollViewD);

    }

    private void initializeTableLayout() {
        tableLayoutA = new TableLayout(getActivity());
        tableLayoutA.setPadding(0, 0, 0, 0);
        tableLayoutB = new TableLayout(getActivity());
        tableLayoutB.setPadding(0, 0, 0, 0);
        tableLayoutB.setId(R.id.tableLayoutB);
        tableLayoutC = new TableLayout(getActivity());
        tableLayoutC.setPadding(0, 0, 0, 0);
        tableLayoutD = new TableLayout(getActivity());
        tableLayoutD.setPadding(0, 0, 0, 0);

        TableLayout.LayoutParams layoutParamsTableLayoutA = new TableLayout.LayoutParams(SCREEN_WIDTH / 5, SCREEN_HEIGHT / 20);
        tableLayoutA.setLayoutParams(layoutParamsTableLayoutA);
        //  tableLayoutA.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        this.relativeLayoutA.addView(tableLayoutA);

        TableLayout.LayoutParams layoutParamsTableLayoutB = new TableLayout.LayoutParams(SCREEN_WIDTH - (SCREEN_WIDTH / 5), SCREEN_HEIGHT / 20);
        tableLayoutB.setLayoutParams(layoutParamsTableLayoutB);
        //  tableLayoutB.setBackgroundColor(getResources().getColor(R.color.colorSecondary));
        this.horizontalScrollViewB.addView(tableLayoutB);

        TableLayout.LayoutParams layoutParamsTableLayoutC = new TableLayout.LayoutParams(SCREEN_WIDTH / 5, SCREEN_HEIGHT - (SCREEN_HEIGHT / 20));
        tableLayoutC.setLayoutParams(layoutParamsTableLayoutC);
        //  tableLayoutC.setBackgroundColor(getResources().getColor(R.color.colorSecondary));
        this.scrollViewC.addView(tableLayoutC);

        TableLayout.LayoutParams layoutParamsTableLayoutD = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT);
        tableLayoutD.setLayoutParams(layoutParamsTableLayoutD);
        this.horizontalScrollViewD.addView(tableLayoutD);

    }

    @Override
    public void onScrollChanged(HorizontalScroll scrollView, int x, int y, int oldx, int oldy) {
        if (scrollView == horizontalScrollViewB) {
            horizontalScrollViewD.scrollTo(x, y);
        } else if (scrollView == horizontalScrollViewD) {
            horizontalScrollViewB.scrollTo(x, y);
        }

    }

    @Override
    public void onScrollChanged(VerticalScroll scrollView, int x, int y, int oldx, int oldy) {
        if (scrollView == scrollViewC) {
            scrollViewD.scrollTo(x, y);
        } else if (scrollView == scrollViewD) {
            scrollViewC.scrollTo(x, y);
        }
    }

    private void addRowToTableA() {
        tableRow = new TableRow(getActivity());
        TableRow.LayoutParams layoutParamsTableRow = new TableRow.LayoutParams(SCREEN_WIDTH / 5, SCREEN_HEIGHT / 20);

        tableRow.setLayoutParams(layoutParamsTableRow);
        ImageView label_date = new ImageView(getActivity());
        label_date.setBackgroundResource(R.drawable.navigationup);
        tableRow.setGravity(Gravity.CENTER);
        tableRow.addView(label_date);
        this.tableLayoutA.addView(tableRow);
    }

    private void initializeRowForTableB() {
        tableRowB = new TableRow(getActivity());
        tableRow.setPadding(0, 0, 0, 0);
        this.tableLayoutB.addView(tableRowB);
    }

    private synchronized void addColumnsToTableB(String text, final int id) {
        tableRow = new TableRow(getActivity());
        TableRow.LayoutParams layoutParamsTableRow = new TableRow.LayoutParams(SCREEN_WIDTH / 5, SCREEN_HEIGHT / 20);
        tableRow.setBackground(getResources().getDrawable(R.drawable.cell_bacground));

        tableRow.setPadding(3, 3, 3, 4);
        tableRow.setLayoutParams(layoutParamsTableRow);
        TextView label_date = new TextView(getActivity());
        label_date.setText(text);
        label_date.setTextSize(getResources().getDimension(R.dimen.cell_text_size));
        this.tableRow.addView(label_date);
        this.tableRow.setTag(id);
        this.tableRowB.addView(tableRow);
        tableColumnCountB++;
    }

    private synchronized void addRowToTableC(String text) {
        TableRow tableRow1 = new TableRow(getActivity());
        TableRow.LayoutParams layoutParamsTableRow1 = new TableRow.LayoutParams(SCREEN_WIDTH / 5, SCREEN_HEIGHT / 20);
        tableRow.setBackground(getResources().getDrawable(R.drawable.cell_bacground));

        tableRow1.setPadding(3, 3, 3, 4);
        tableRow1.setLayoutParams(layoutParamsTableRow1);
        TextView label_date = new TextView(getActivity());
        label_date.setText(text);
        label_date.setTextSize(getResources().getDimension(R.dimen.cell_text_size));
        tableRow1.addView(label_date);

        TableRow tableRow = new TableRow(getActivity());
        TableRow.LayoutParams layoutParamsTableRow = new TableRow.LayoutParams(SCREEN_WIDTH / 5, SCREEN_HEIGHT / 20);
        tableRow.setBackground(getResources().getDrawable(R.drawable.cell_bacground));

        tableRow.setPadding(0, 0, 0, 0);
        tableRow.setLayoutParams(layoutParamsTableRow);
        tableRow.addView(tableRow1);
        this.tableLayoutC.addView(tableRow, tableRowCountC);
        tableRowCountC++;
    }

    private synchronized void initializeRowForTableD(int pos) {
        TableRow tableRowB = new TableRow(getActivity());
        TableRow.LayoutParams layoutParamsTableRow = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, SCREEN_HEIGHT / 20);
        tableRowB.setPadding(0, 0, 0, 0);
        tableRowB.setLayoutParams(layoutParamsTableRow);
        this.tableLayoutD.addView(tableRowB, pos);
    }

    private synchronized void addColumnToTableAtD(final int rowPos, String text) {
        TableRow tableRowAdd = (TableRow) this.tableLayoutD.getChildAt(rowPos);
        tableRow = new TableRow(getActivity());
        TableRow.LayoutParams layoutParamsTableRow = new TableRow.LayoutParams(SCREEN_WIDTH / 5, SCREEN_HEIGHT / 20);

        if (a == 1) {
            a++;
            layoutParamsTableRow.span = 2;

        }
        if (b == 80) {

            layoutParamsTableRow.span = 3;


        }
        b++;

        tableRow.setPadding(3, 3, 3, 4);
        tableRow.setBackground(getResources().getDrawable(R.drawable.cell_bacground));
        tableRow.setLayoutParams(layoutParamsTableRow);
        TextView label_date = new TextView(getActivity());
        label_date.setText(text);
        label_date.setTextSize(getResources().getDimension(R.dimen.cell_text_size));
        label_date.setTextColor(Color.WHITE);


        // label_date.setTextSize(TypedValue.COMPLEX_UNIT_SP,44);
        tableRow.setTag(label_date);

        this.tableRow.addView(label_date);
        tableRowAdd.addView(tableRow);









/*

        TableRow.LayoutParams params = (TableRow.LayoutParams)editText.getLayoutParams();
        params.span = toSpan;
        editText.setLayoutParams(params);*/
    }

    private void createCompleteColumn(String value) {
        int i = 0;
        int j = tableRowCountC - 1;
        for (int k = i; k <= j; k++) {
            addColumnToTableAtD(k, value);
        }
    }

    private void createCompleteRow(String value) {
        initializeRowForTableD(0);
        int i = 0;
        int j = tableColumnCountB - 1;
        int pos = tableRowCountC - 1;
        for (int k = i; k <= j; k++) {
            addColumnToTableAtD(pos, value);
        }
    }

    void staticValues() {
        timeArratlist.add("12:00 AM");
        timeArratlist.add("12:30 AM");
        timeArratlist.add("01:00 AM");
        timeArratlist.add("01:30 AM");
        timeArratlist.add("02:00 AM");
        timeArratlist.add("02:30 AM");
        timeArratlist.add("03:00 AM");
        timeArratlist.add("03:30 AM");
        timeArratlist.add("04:00 AM");
        timeArratlist.add("04:30 AM");
        timeArratlist.add("05:00 AM");
        timeArratlist.add("05:30 AM");
        timeArratlist.add("06:00 AM");
        timeArratlist.add("06:30 AM");
        timeArratlist.add("07:00 AM");
        timeArratlist.add("07:30 AM");
        timeArratlist.add("08:00 AM");
        timeArratlist.add("08:30 AM");
        timeArratlist.add("09:00 AM");
        timeArratlist.add("09:30 AM");
        timeArratlist.add("10:00 AM");
        timeArratlist.add("10:30 AM");
        timeArratlist.add("11:00 AM");
        timeArratlist.add("11:30 AM");
        timeArratlist.add("12:00 PM");
        timeArratlist.add("12:30 PM");
        timeArratlist.add("01:00 PM");
        timeArratlist.add("01:30 PM");
        timeArratlist.add("02:00 PM");
        timeArratlist.add("02:30 PM");
        timeArratlist.add("03:00 PM");
        timeArratlist.add("03:30 PM");
        timeArratlist.add("04:00 PM");
        timeArratlist.add("04:30 PM");
        timeArratlist.add("05:00 PM");
        timeArratlist.add("05:30 PM");
        timeArratlist.add("06:00 PM");
        timeArratlist.add("06:30 PM");
        timeArratlist.add("07:00 PM");
        timeArratlist.add("07:30 PM");
        timeArratlist.add("08:00 PM");
        timeArratlist.add("08:30 PM");
        timeArratlist.add("09:00 PM");
        timeArratlist.add("09:00 PM");
        timeArratlist.add("09:30 PM");
        timeArratlist.add("10:00 PM");
        timeArratlist.add("10:30 PM");
        timeArratlist.add("11:00 PM");


        channelNamesArratlist.add("Colors");
        channelNamesArratlist.add("Udaya TV HD");
        channelNamesArratlist.add("Star Suvarna");
        channelNamesArratlist.add("Zee Kannada");
        channelNamesArratlist.add("DD Chandana");
        channelNamesArratlist.add("Udaya TV");
        channelNamesArratlist.add("Colors HD");
        channelNamesArratlist.add("Udaya Movies");
        channelNamesArratlist.add("Zee Kannada");
        channelNamesArratlist.add("Udaya Music");
        channelNamesArratlist.add("Star Suvarna");
        channelNamesArratlist.add("Kasthuri");
        channelNamesArratlist.add("Star Suvarna Plus");
        channelNamesArratlist.add("Udaya Comedy");
        channelNamesArratlist.add("Chintu TV");
        channelNamesArratlist.add("Raj Musix Kannada");
        channelNamesArratlist.add("Public Music");
        channelNamesArratlist.add("Polimer Kannada");
        channelNamesArratlist.add("Kalki Kannada");
        channelNamesArratlist.add("Saral Jeevan");
        channelNamesArratlist.add("Colors Super");
        channelNamesArratlist.add("Star Sports 1 Kannada");
        channelNamesArratlist.add("Udaya News");
        channelNamesArratlist.add("TV9 Karnataka");
        channelNamesArratlist.add("Suvarna News");
        channelNamesArratlist.add("Samaya News");
        channelNamesArratlist.add("Janasri News");
        channelNamesArratlist.add("Kasthuri Newz 24");
        channelNamesArratlist.add("ETV News Kannada");
        channelNamesArratlist.add("Raj News Kannada");
        channelNamesArratlist.add("Dighvijay TV 24X7");
        channelNamesArratlist.add("Sri Sankara TV");
        channelNamesArratlist.add("Sri Venkateswara Bhakti Channel");
        channelNamesArratlist.add("STAR Plus");
        channelNamesArratlist.add("Zee TV");
        channelNamesArratlist.add("Zee Anmol");
        channelNamesArratlist.add("Zing");
        channelNamesArratlist.add("Bindass");
        channelNamesArratlist.add("MTV India");
        channelNamesArratlist.add("E24");
        channelNamesArratlist.add("Star Utsav");
        channelNamesArratlist.add(" Life OK");
        channelNamesArratlist.add("Sony SAB");
        channelNamesArratlist.add("Bindass");
        channelNamesArratlist.add("MTV India");
        channelNamesArratlist.add("E24");
        channelNamesArratlist.add("Star Utsav");
        channelNamesArratlist.add(" Life OK");
        channelNamesArratlist.add("Sony SAB");


        colorTvArraylist.add("Dil Sambhal Ja Zara ");
        colorTvArraylist.add("shqbaaaz ");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        colorTvArraylist.add("Meri Durga ");
        colorTvArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Rishton Ka Chakravyuh ");
        colorTvArraylist.add("Chandra Nandni ");
        colorTvArraylist.add("Naamkarann ");
        colorTvArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        colorTvArraylist.add("Ishqbaaaz ");
        colorTvArraylist.add("Dil Sambhal Ja Zara ");
        colorTvArraylist.add("Rishton Ka Chakravyuh ");
        colorTvArraylist.add("Naamkarann");
        colorTvArraylist.add("Dance Champions ");
        colorTvArraylist.add("Naamkarann");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Rishton Ka Chakravyuh ");
        colorTvArraylist.add("Meri Durga ");
        colorTvArraylist.add("Chandra Nandni ");
        colorTvArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Dil Sambhal Ja Zara ");
        colorTvArraylist.add("shqbaaaz ");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        colorTvArraylist.add("Meri Durga ");
        colorTvArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Rishton Ka Chakravyuh ");
        colorTvArraylist.add("Chandra Nandni ");
        colorTvArraylist.add("Naamkarann ");
        colorTvArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        colorTvArraylist.add("Ishqbaaaz ");
        colorTvArraylist.add("Dil Sambhal Ja Zara ");
        colorTvArraylist.add("Rishton Ka Chakravyuh ");
        colorTvArraylist.add("Naamkarann");
        colorTvArraylist.add("Dance Champions ");
        colorTvArraylist.add("Naamkarann");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Rishton Ka Chakravyuh ");
        colorTvArraylist.add("Meri Durga ");
        colorTvArraylist.add("Chandra Nandni ");
        colorTvArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Dil Sambhal Ja Zara ");
        colorTvArraylist.add("shqbaaaz ");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        colorTvArraylist.add("Meri Durga ");
        colorTvArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Rishton Ka Chakravyuh ");
        colorTvArraylist.add("Chandra Nandni ");
        colorTvArraylist.add("Naamkarann ");
        colorTvArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        colorTvArraylist.add("Ishqbaaaz ");
        colorTvArraylist.add("Dil Sambhal Ja Zara ");
        colorTvArraylist.add("Rishton Ka Chakravyuh ");
        colorTvArraylist.add("Naamkarann");
        colorTvArraylist.add("Dance Champions ");
        colorTvArraylist.add("Naamkarann");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Rishton Ka Chakravyuh ");
        colorTvArraylist.add("Meri Durga ");
        colorTvArraylist.add("Chandra Nandni ");
        colorTvArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Dil Sambhal Ja Zara ");
        colorTvArraylist.add("shqbaaaz ");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        colorTvArraylist.add("Meri Durga ");
        colorTvArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Rishton Ka Chakravyuh ");
        colorTvArraylist.add("Chandra Nandni ");
        colorTvArraylist.add("Naamkarann ");
        colorTvArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        colorTvArraylist.add("Ishqbaaaz ");
        colorTvArraylist.add("Dil Sambhal Ja Zara ");
        colorTvArraylist.add("Rishton Ka Chakravyuh ");
        colorTvArraylist.add("Naamkarann");
        colorTvArraylist.add("Dance Champions ");
        colorTvArraylist.add("Naamkarann");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Rishton Ka Chakravyuh ");
        colorTvArraylist.add("Meri Durga ");
        colorTvArraylist.add("Chandra Nandni ");
        colorTvArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Naamkarann");
        colorTvArraylist.add("Ye Hai Mohabbatein ");
        colorTvArraylist.add("Rishton Ka Chakravyuh ");
        colorTvArraylist.add("Meri Durga ");
        colorTvArraylist.add("Chandra Nandni ");


        udayaNewsArraylist.add("Naamkarann");
        udayaNewsArraylist.add("Dance Champions");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Rishton Ka Chakravyuh ");
        udayaNewsArraylist.add("Chandra Nandni ");
        udayaNewsArraylist.add("Naamkarann ");
        udayaNewsArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        udayaNewsArraylist.add("Ishqbaaaz ");
        udayaNewsArraylist.add("Dil Sambhal Ja Zara ");
        udayaNewsArraylist.add("Rishton Ka Chakravyuh ");
        udayaNewsArraylist.add("Naamkarann");
        udayaNewsArraylist.add("Dance Champions ");
        udayaNewsArraylist.add("Naamkarann");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Rishton Ka Chakravyuh ");
        udayaNewsArraylist.add("Meri Durga ");
        udayaNewsArraylist.add("Chandra Nandni ");
        udayaNewsArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Dil Sambhal Ja Zara ");
        udayaNewsArraylist.add("shqbaaaz ");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        udayaNewsArraylist.add("Meri Durga ");
        udayaNewsArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Rishton Ka Chakravyuh ");
        udayaNewsArraylist.add("Chandra Nandni ");
        udayaNewsArraylist.add("Naamkarann ");
        udayaNewsArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        udayaNewsArraylist.add("Ishqbaaaz ");
        udayaNewsArraylist.add("Dil Sambhal Ja Zara ");
        udayaNewsArraylist.add("Rishton Ka Chakravyuh ");
        udayaNewsArraylist.add("Naamkarann");
        udayaNewsArraylist.add("Dance Champions ");
        udayaNewsArraylist.add("Naamkarann");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Rishton Ka Chakravyuh ");
        udayaNewsArraylist.add("Meri Durga ");
        udayaNewsArraylist.add("Chandra Nandni ");
        udayaNewsArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Dil Sambhal Ja Zara ");
        udayaNewsArraylist.add("shqbaaaz ");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        udayaNewsArraylist.add("Meri Durga ");
        udayaNewsArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Rishton Ka Chakravyuh ");
        udayaNewsArraylist.add("Chandra Nandni ");
        udayaNewsArraylist.add("Naamkarann ");
        udayaNewsArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        udayaNewsArraylist.add("Ishqbaaaz ");
        udayaNewsArraylist.add("Dil Sambhal Ja Zara ");
        udayaNewsArraylist.add("Rishton Ka Chakravyuh ");
        udayaNewsArraylist.add("Naamkarann");
        udayaNewsArraylist.add("Dance Champions ");
        udayaNewsArraylist.add("Naamkarann");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Rishton Ka Chakravyuh ");
        udayaNewsArraylist.add("Meri Durga ");
        udayaNewsArraylist.add("Chandra Nandni ");
        udayaNewsArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Naamkarann");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Rishton Ka Chakravyuh ");
        udayaNewsArraylist.add("Meri Durga ");
        udayaNewsArraylist.add("Chandra Nandni ");
        udayaNewsArraylist.add("Dil Sambhal Ja Zara ");
        udayaNewsArraylist.add("shqbaaaz ");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        udayaNewsArraylist.add("Meri Durga ");
        udayaNewsArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Rishton Ka Chakravyuh ");
        udayaNewsArraylist.add("Chandra Nandni ");
        udayaNewsArraylist.add("Naamkarann ");
        udayaNewsArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        udayaNewsArraylist.add("Ishqbaaaz ");
        udayaNewsArraylist.add("Dil Sambhal Ja Zara ");
        udayaNewsArraylist.add("Rishton Ka Chakravyuh ");
        udayaNewsArraylist.add("Naamkarann");
        udayaNewsArraylist.add("Dance Champions ");
        udayaNewsArraylist.add("Naamkarann");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Rishton Ka Chakravyuh ");
        udayaNewsArraylist.add("Meri Durga ");
        udayaNewsArraylist.add("Chandra Nandni ");
        udayaNewsArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        udayaNewsArraylist.add("Ye Hai Mohabbatein ");
        udayaNewsArraylist.add("Dil Sambhal Ja Zara ");
        udayaNewsArraylist.add("shqbaaaz ");

        udayaArraylist.add("Rishton Ka Chakravyuh ");
        udayaArraylist.add("Chandra Nandni ");
        udayaArraylist.add("Naamkarann ");
        udayaArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        udayaArraylist.add("Ishqbaaaz ");
        udayaArraylist.add("Dil Sambhal Ja Zara ");
        udayaArraylist.add("Rishton Ka Chakravyuh ");
        udayaArraylist.add("Naamkarann");
        udayaArraylist.add("Dance Champions ");
        udayaArraylist.add("Naamkarann");
        udayaArraylist.add("Ye Hai Mohabbatein ");
        udayaArraylist.add("Rishton Ka Chakravyuh ");
        udayaArraylist.add("Meri Durga ");
        udayaArraylist.add("Chandra Nandni ");
        udayaArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        udayaArraylist.add("Ye Hai Mohabbatein ");
        udayaArraylist.add("Dil Sambhal Ja Zara ");
        udayaArraylist.add("shqbaaaz ");
        udayaArraylist.add("Ye Hai Mohabbatein ");
        udayaArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        udayaArraylist.add("Meri Durga ");
        udayaArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        udayaArraylist.add("Ye Hai Mohabbatein ");
        udayaArraylist.add("Rishton Ka Chakravyuh ");
        udayaArraylist.add("Chandra Nandni ");
        udayaArraylist.add("Naamkarann ");
        udayaArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        udayaArraylist.add("Ishqbaaaz ");
        udayaArraylist.add("Dil Sambhal Ja Zara ");
        udayaArraylist.add("Rishton Ka Chakravyuh ");
        udayaArraylist.add("Naamkarann");
        udayaArraylist.add("Dance Champions ");
        udayaArraylist.add("Naamkarann");
        udayaArraylist.add("Ye Hai Mohabbatein ");
        udayaArraylist.add("Rishton Ka Chakravyuh ");
        udayaArraylist.add("Meri Durga ");
        udayaArraylist.add("Chandra Nandni ");
        udayaArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        udayaArraylist.add("Ye Hai Mohabbatein ");
        udayaArraylist.add("Ye Hai Mohabbatein ");
        udayaArraylist.add("Naamkarann");
        udayaArraylist.add("Ye Hai Mohabbatein ");
        udayaArraylist.add("Rishton Ka Chakravyuh ");
        udayaArraylist.add("Meri Durga ");
        udayaArraylist.add("Chandra Nandni ");
        udayaArraylist.add("Dil Sambhal Ja Zara ");
        udayaArraylist.add("shqbaaaz ");
        udayaArraylist.add("Ye Hai Mohabbatein ");
        udayaArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        udayaArraylist.add("Meri Durga ");
        udayaArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        udayaArraylist.add("Ye Hai Mohabbatein ");
        udayaArraylist.add("Rishton Ka Chakravyuh ");
        udayaArraylist.add("Chandra Nandni ");
        udayaArraylist.add("Naamkarann ");
        udayaArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        udayaArraylist.add("Ishqbaaaz ");
        udayaArraylist.add("Dil Sambhal Ja Zara ");
        udayaArraylist.add("Rishton Ka Chakravyuh ");
        udayaArraylist.add("Naamkarann");
        udayaArraylist.add("Dance Champions ");
        udayaArraylist.add("Naamkarann");
        udayaArraylist.add("Ye Hai Mohabbatein ");
        udayaArraylist.add("Rishton Ka Chakravyuh ");
        udayaArraylist.add("Meri Durga ");
        udayaArraylist.add("Chandra Nandni ");
        udayaArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        udayaArraylist.add("Ye Hai Mohabbatein ");
        udayaArraylist.add("Dil Sambhal Ja Zara ");
        udayaArraylist.add("shqbaaaz ");
        udayaArraylist.add("Ye Hai Mohabbatein ");
        udayaArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        udayaArraylist.add("Meri Durga ");
        udayaArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        udayaArraylist.add("Ye Hai Mohabbatein ");
        udayaArraylist.add("Rishton Ka Chakravyuh ");
        udayaArraylist.add("Chandra Nandni ");
        udayaArraylist.add("Naamkarann ");
        udayaArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        udayaArraylist.add("Ishqbaaaz ");
        udayaArraylist.add("Dil Sambhal Ja Zara ");
        udayaArraylist.add("Rishton Ka Chakravyuh ");
        udayaArraylist.add("Naamkarann");
        udayaArraylist.add("Dance Champions ");
        udayaArraylist.add("Naamkarann");
        udayaArraylist.add("Ye Hai Mohabbatein ");
        udayaArraylist.add("Rishton Ka Chakravyuh ");
        udayaArraylist.add("Meri Durga ");
        udayaArraylist.add("Chandra Nandni ");
        udayaArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        udayaArraylist.add("Ye Hai Mohabbatein ");
        udayaArraylist.add("Dil Sambhal Ja Zara ");
        udayaArraylist.add("shqbaaaz ");
        udayaArraylist.add("Ye Hai Mohabbatein ");
        udayaArraylist.add("Yeh Rishta Kya Kehlata Hai ");
        udayaArraylist.add("Meri Durga ");
        udayaArraylist.add("Tu Sooraj Main Saanjh Piyaji ");
        udayaArraylist.add("Ye Hai Mohabbatein ");


    }



}


