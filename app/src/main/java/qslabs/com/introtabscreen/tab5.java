package qslabs.com.introtabscreen;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class tab5 extends Fragment {
    private static final String PAGE_NUM = "Page_num";

    private int mPage_Num;

    private OnFragmentInteractionListener mListener;

    public TextView tab5_Text;

    public tab5() {
        // Required empty public constructor
    }

    public static tab5 newInstance(int param1) {
        tab5 fragment = new tab5();
        Bundle args = new Bundle();
        args.putInt(PAGE_NUM, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPage_Num = getArguments().getInt(PAGE_NUM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab5, container, false);
        tab5_Text = v.findViewById(R.id.text);

        Typeface t = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/BebasNeue Book.otf");
        tab5_Text.setTypeface(t);

        v.setTag(mPage_Num); // must be set in order to identify the page in the IntroPageTransformer

        return v;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
