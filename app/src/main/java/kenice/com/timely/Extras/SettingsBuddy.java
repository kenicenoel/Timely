package kenice.com.timely.Extras;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Software Developer on 7/20/2016.
 */
public class SettingsBuddy
{

    private String fullName;
    private Context context;
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;
    private String DEFAULT = "N/A"; // A default constant for use with sharedPreferences


    public SettingsBuddy(Context context)
    {
        this.context = context;
        this.settings = context.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);

    }


    // Get the Full name of the current logged in user
    public String getFullName()
    {
        String name = settings.getString("name", DEFAULT);

        if( !name.equals(DEFAULT))
        {
            return name;
        }

        else
        {
            return DEFAULT;
        }

    }



    public void setFullName(String str)
    {
        this.editor = settings.edit();
        editor.putString("name", str);
        editor.commit();
    }


    // Checks if this is the first time the app is running
    public boolean isFirstTimeRun()
    {
        String name = getFullName();
        if( name.equals(DEFAULT))
        {
            return true;
        }

        return false;

    }


}
