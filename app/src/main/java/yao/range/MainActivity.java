package yao.range;

import yao.range.RangeSeekBar.OnRangeSeekBarChangeListener;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	protected static final String TAG = MainActivity.class.getSimpleName();
	RelativeLayout rl_all;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// create RangeSeekBar as Integer range between 20 and 75
		RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(20, 75, this);
		// seekBar.setNotifyWhileDragging(true);
		seekBar.setOnRangeSeekBarChangeListener(new OnRangeSeekBarChangeListener<Integer>() {
			@Override
			public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
				// handle changed range values
				Log.i(TAG, "User selected new range values: MIN=" + minValue + ", MAX=" + maxValue);
			}
		});

		// add RangeSeekBar to pre-defined layout
		ViewGroup layout = (ViewGroup) findViewById(R.id.rl_all);
		layout.addView(seekBar);

	}

}