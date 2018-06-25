package aysusayin.com.mynotebook;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Aysu on 9.07.2017.
 */

public class UserAdapter extends BaseAdapter {

    private Context contex;
    private ArrayList<Note> arrayList;

    public UserAdapter(Context contex, ArrayList<Note> arrayList) {
        this.contex = contex;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) contex
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_row,null);

            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
            convertView.setTag(R.id.title_textview,viewHolder.textViewTitle);
            convertView.setTag(R.id.date_textview,viewHolder.textViewDate);
            convertView.setTag(R.id.mail_textview,viewHolder.textViewMail);
            convertView.setTag(R.id.note_textview,viewHolder.textViewNote);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Note model = arrayList.get(position);
        viewHolder.textViewTitle.setText(""+model.getTitle().toString().trim());
        viewHolder.textViewDate.setText(""+model.getDate().toString().trim());
        viewHolder.textViewMail.setText(""+model.getUser().toString().trim());
        String note =  model.getNote().toString().trim();
        String[] noteLine = note.split("\n");

        if(noteLine[0].length()>100){
            viewHolder.textViewNote.setText(""+noteLine[0].substring(0,100)+"...");
        }else viewHolder.textViewNote.setText(""+noteLine[0]+"...");

        return convertView;
    }

    private class ViewHolder{
        private TextView textViewTitle;
        private TextView textViewDate;
        private TextView textViewNote;
        private TextView textViewMail;

        public ViewHolder(View convertView){
            textViewDate = (TextView) convertView.findViewById(R.id.date_textview);
            textViewNote = (TextView) convertView.findViewById(R.id.note_textview);
            textViewTitle = (TextView) convertView.findViewById(R.id.title_textview);
            textViewMail = (TextView) convertView.findViewById(R.id.mail_textview);
        }

    }
}
