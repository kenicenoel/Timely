package kenice.com.timely;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class CreateTimeTableFragment extends Fragment implements View.OnClickListener
{
    Button saveTimetable;
    View view;

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
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {

        super.onActivityCreated(savedInstanceState);
        saveTimetable = (Button) view.findViewById(R.id.saveTimeTable);
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
