package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mohammed Maaz S on 22-03-18.
 */

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {
    private static final String LOCATION_SEPARATOR = " of ";

    public EarthQuakeAdapter(Context context, ArrayList<EarthQuake> earthQuakeAdapter) {
        super(context, 0,earthQuakeAdapter);
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
View listItemView=convertView;
if (listItemView==null){
    listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list,parent,false);
}
EarthQuake currentEarthQuake=getItem(position);
        TextView magnitude=(TextView)listItemView.findViewById(R.id.magnitude);
        String mag=formatMagnitude(currentEarthQuake.getMagnitude());
        magnitude.setText(mag);
        //Split the address in city and place bt two textviews
        String originalLocation = currentEarthQuake.getCity();

        // If the original location string (i.e. "5km N of Cairo, Egypt") contains
        // a primary location (Cairo, Egypt) and a location offset (5km N of that city)
        // then store the primary location separately from the location offset in 2 Strings,
        // so they can be displayed in 2 TextViews.
        String primaryLocation;
        String locationOffset;

        // Check whether the originalLocation string contains the " of " text
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            // Split the string into different parts (as an array of Strings)
            // based on the " of " text. We expect an array of 2 Strings, where
            // the first String will be "5km N" and the second String will be "Cairo, Egypt".
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            // Location offset should be "5km N " + " of " --> "5km N of"
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            // Primary location should be "Cairo, Egypt"
            primaryLocation = parts[1];
        } else {
            // Otherwise, there is no " of " text in the originalLocation string.
            // Hence, set the default location offset to say "Near the".
            locationOffset = "near the";
            // The primary location will be the full location string "Pacific-Antarctic Ridge".
            primaryLocation = originalLocation;
        }

        // Find the TextView with view ID location
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.place);
        // Display the location of the current earthquake in that TextView
        primaryLocationView.setText(locationOffset);

        // Find the TextView with view ID location offset
        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.city);
        // Display the location offset of the current earthquake in that TextView
        locationOffsetView.setText(primaryLocation);
        TextView date=(TextView)listItemView.findViewById(R.id.date);
        Date dateObject = new Date(currentEarthQuake.getDate());

        String dateToDisplay = formatDate(dateObject);
        date.setText(dateToDisplay);
        TextView time=(TextView)listItemView.findViewById(R.id.time);
        time.setText(formatTime(dateObject));
        //Magnitude circle
        GradientDrawable magCircle=(GradientDrawable)magnitude.getBackground();
        int magnitudeColor=getMagnitudeColor(currentEarthQuake.getMagnitude());
        magCircle.setColor(magnitudeColor);

        return listItemView;
    }
    private String formatDate(Date dataObject){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("LLL dd, yyyy");
return dateFormatter.format(dataObject);
    }
    private String formatTime(Date dataObject){
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        return timeFormatter.format(dataObject);
    }
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
    //Setting the magnitude color
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int)Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

}
