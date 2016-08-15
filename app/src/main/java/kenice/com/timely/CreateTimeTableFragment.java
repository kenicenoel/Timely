package kenice.com.timely;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import kenice.com.timely.Adaptors.DatabaseAdaptor;


public class CreateTimeTableFragment extends Fragment implements View.OnClickListener
{
    Button saveTimetable;
    private View view;
    private Spinner daySpinner;
    TextView timePicker;
    ArrayList<String> dateTimeValues;
    ImageView addNewDayTime;
    TextView selectDaysLabel;
    LinearLayout selectedDaysAndTime;
    DatabaseAdaptor helper;

    private Button addNewCourse;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_createtimetable, container, false);
        helper = new DatabaseAdaptor(getContext());
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {

        super.onActivityCreated(savedInstanceState);

        addNewCourse = (Button) view.findViewById(R.id.saveAndContinueAdding);
        selectDaysLabel = (TextView) view.findViewById(R.id.selectDaysLabel);
        saveTimetable = (Button) view.findViewById(R.id.saveTimeTable);
        addNewDayTime = (ImageView) view.findViewById(R.id.addNewDayTimeIcon);
        selectedDaysAndTime = (LinearLayout) view.findViewById(R.id.selectedDaysAndTimes);
        addNewDayTime.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dateTimeValues.add(daySpinner.getSelectedItem().toString()+","+timePicker.getText());

                TextView dayTime = new TextView(getContext());
                dayTime.setText(daySpinner.getSelectedItem().toString()+"'s at "+timePicker.getText());

                selectedDaysAndTime.addView(dayTime);
                timePicker.setText("Choose time");
                daySpinner.setSelection(0, true);
            }
        });


        dateTimeValues = new ArrayList<>();
        daySpinner = (Spinner) view.findViewById(R.id.courseDaysSelecter);
        timePicker = (TextView) view.findViewById(R.id.courseTimeSelector);
        timePicker.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(getFragmentManager(),"TimePicker");

            }
        });

        // Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.daysOfWeekArray, R.layout.spinner);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        daySpinner.setAdapter(adapter);

        addNewCourse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
    }

    @Override
    public void onStart()
    {
        super.onStart();
        saveTimetable.setOnClickListener(this);


    }


    @Override
    public void onClick(View v)
    {
        Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "You clicked a button!", Snackbar.LENGTH_LONG);
        snackbar.show();

    }
}
