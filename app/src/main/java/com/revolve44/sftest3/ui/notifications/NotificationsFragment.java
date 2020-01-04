package com.revolve44.sftest3.ui.notifications;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.revolve44.sftest3.MainActivity;
import com.revolve44.sftest3.R;

public class NotificationsFragment extends Fragment {


    private NotificationsViewModel notificationsViewModel;

    private EditText num1;
    private EditText num2;
    private Button add;
    private TextView result;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        final EditText num1 = root.findViewById(R.id.editText4);
        final EditText num2 = root.findViewById(R.id.editText5);
        final Button add = root.findViewById(R.id.superbutton4);
        final TextView lol = root.findViewById(R.id.output);

        notificationsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });



        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Now we can have sum of two input numbers!!!
                int number1 = Integer.parseInt(num1.getText().toString());
                int number2 = Integer.parseInt(num2.getText().toString());
                int sum = number1 + number2;

                lol.setText("Answer is " + sum);

                // do something
            }


        });
        return root;
    }
//    private void answer() {
//        int number1 = Integer.parseInt(num1.getText().toString());
//        int number2 = Integer.parseInt(num2.getText().toString());
//        int sum = number1 + number2;
//        result.setText("Answer is " + sum);
//
//    }


}