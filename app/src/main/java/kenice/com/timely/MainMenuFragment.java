package kenice.com.timely;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kenice.com.timely.Extras.SettingsBuddy;


public class MainMenuFragment extends Fragment implements View.OnClickListener
{
    Button addTimeTable;
    SettingsBuddy buddy;
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
        view =  inflater.inflate(R.layout.fragment_mainmenu, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        addTimeTable = (Button) view.findViewById(R.id.addTimeTableButton);
        buddy = new SettingsBuddy(getContext());
    }

    @Override
    public void onStart()
    {
        super.onStart();
        if (!buddy.doesATimeTableExist())
        {
            addTimeTable.setOnClickListener(this);
        }



    }


    @Override
    public void onClick(View v)
    {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHolder, new CreateTimeTableFragment(), "CreateTimeTableFragment")
                .addToBackStack(null).commit();
    }
}
