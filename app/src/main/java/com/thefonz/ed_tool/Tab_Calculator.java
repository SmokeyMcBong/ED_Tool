/**
 * Created by theFONZ on 10/08/2015.
 */

package com.thefonz.ed_tool;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.util.Objects;

public class Tab_Calculator extends Fragment {

    private static EditText nDisplay;
    private static EditText fDisplay;
    private static DecimalFormat df;
    private static long val1;
    private static long val2;
    private boolean add;
    private boolean sub;
    private boolean div;
    private boolean mul;
    private boolean eq;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myFragmentView = inflater.inflate(R.layout.tab_calculator, container, false);

        final Button b1 = (Button) myFragmentView.findViewById(R.id.cb1);
        final Button b2 = (Button) myFragmentView.findViewById(R.id.cb2);
        final Button b3 = (Button) myFragmentView.findViewById(R.id.cb3);
        final Button b4 = (Button) myFragmentView.findViewById(R.id.cb4);
        final Button b5 = (Button) myFragmentView.findViewById(R.id.cb5);
        final Button b6 = (Button) myFragmentView.findViewById(R.id.cb6);
        final Button b7 = (Button) myFragmentView.findViewById(R.id.cb7);
        final Button b8 = (Button) myFragmentView.findViewById(R.id.cb8);
        final Button b9 = (Button) myFragmentView.findViewById(R.id.cb9);
        final Button b0 = (Button) myFragmentView.findViewById(R.id.cb10);
        final Button badd = (Button) myFragmentView.findViewById(R.id.cb12);
        final Button bsub = (Button) myFragmentView.findViewById(R.id.cb13);
        final Button bmul = (Button) myFragmentView.findViewById(R.id.cb14);
        final Button bdiv = (Button) myFragmentView.findViewById(R.id.cb15);
        final Button beq = (Button) myFragmentView.findViewById(R.id.cb16);
        final Button bclr = (Button) myFragmentView.findViewById(R.id.clr);

        nDisplay = (EditText) myFragmentView.findViewById(R.id.cet);
        nDisplay.setKeyListener(null);
        nDisplay.requestFocus();

        fDisplay = (EditText) myFragmentView.findViewById(R.id.cetfunction);
        fDisplay.setKeyListener(null);

        // Set DecimalFormat for our numbers
        df = new DecimalFormat("#,###,###,###,###,###,##0");

        // Number Buttons (1234567890)
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNumber("1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNumber("2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNumber("3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNumber("4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNumber("5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNumber("6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNumber("7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNumber("8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNumber("9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNumber("0");
            }
        });

        // Function Buttons (+-x/=)
        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Objects.equals(formattedNumbers(), "")) {
                    showFunction("+");
                    val1 = Integer.parseInt(formattedNumbers());
                    add = true;
                    nDisplay.setText(null);
                }
            }
        });
        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Objects.equals(formattedNumbers(), "")) {
                    showFunction("-");
                    val1 = Integer.parseInt(formattedNumbers());
                    sub = true;
                    nDisplay.setText(null);
                }
            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Objects.equals(formattedNumbers(), "")) {
                    showFunction("/");
                    val1 = Integer.parseInt(formattedNumbers());
                    div = true;
                    nDisplay.setText(null);
                }
            }
        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Objects.equals(formattedNumbers(), "")) {
                    showFunction("x");
                    val1 = Integer.parseInt(formattedNumbers());
                    mul = true;
                    nDisplay.setText(null);
                }
            }
        });
        beq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Objects.equals(formattedNumbers(), "")) {
                    eq = true;
                    showFunction("=");
                    val2 = Integer.parseInt(formattedNumbers());
                    if (add) {
                        long outval = val1 + val2;
                        nDisplay.setText(df.format(outval));
                        add = false;
                    }
                    if (sub) {
                        long outval = val1 - val2;
                        nDisplay.setText(df.format(outval));
                        sub = false;
                    }
                    if (mul) {
                        long outval = val1 * val2;
                        nDisplay.setText(df.format(outval));
                        mul = false;
                    }
                    if (div) {
                        long outval = val1 / val2;
                        nDisplay.setText(df.format(outval));
                        div = false;
                    }
                }
            }
        });

        // Clear Button
        bclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAll();
            }
        });

        return myFragmentView;
    }

    // Add numbers to display
    private void sendNumber(String number) {
        final int maxLimit = 11;
        if (eq) {
            nDisplay.setText(null);
            fDisplay.setText(null);
            eq = false;
        }
        if (nDisplay.length() != maxLimit ) {
            nDisplay.setText(nDisplay.getText() + number);
            int display = Integer.parseInt(formattedNumbers());
            nDisplay.setText(df.format(display));
        }
    }

    // Show which function is currently selected
    private static void showFunction(String function) {
        String fDisplayCheck = fDisplay.getText().toString();
        if (!fDisplayCheck.contains("+-/*")) {
            fDisplay.setText(function);
        }
    }

    // Remove all EXCEPT numbers and return string
    private static String formattedNumbers() {
        return nDisplay.getText().toString().replaceAll("[^0-9]", "");
    }

    // Clear both int values and set both editText's to null
    private void clearAll() {
        nDisplay.setText(null);
        fDisplay.setText(null);
        eq = false;
        val1 = 0;
        val2 = 0;
    }
}