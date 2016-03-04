package org.free.jayeshb.readtracker;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class ReadTrackerActivityFragment extends Fragment {

    private ListView listView;
    private ArrayAdapter<String> mAdapter;
    ArrayList<String> listItems=new ArrayList<String>();

    public ReadTrackerActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_read_tracker, container, false);
        listView = (ListView)rootView.findViewById(R.id.bookList);
        final String[] booksArray = { "Murakami","Wordsworth","Heigashino","Kobo","Woolf","Twain" };
        listItems.addAll(Arrays.asList(booksArray));
        mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(mAdapter);
        FloatingActionButton fab = (FloatingActionButton)rootView.findViewById(R.id.addBook);
        fab.bringToFront();
        final EditText editText = (EditText)rootView.findViewById(R.id.newBook);
        editText.bringToFront();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String book = editText.getText().toString();
                listItems.add(book);
                mAdapter.notifyDataSetChanged();
            }
        });

        return rootView;
    }
}
