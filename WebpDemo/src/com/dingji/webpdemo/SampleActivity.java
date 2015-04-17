package com.dingji.webpdemo;

import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SampleActivity extends Activity {

	private static int sImageId = 0;

	private static final int[] sImageArray = { R.raw.image0, R.raw.image1,
			R.raw.image2, R.raw.image3, R.raw.image4 };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initViews();
	}

	private void initViews() {
		final ImageView imageView = (ImageView) findViewById(R.id.iv_webp);

		final Button button = (Button) findViewById(R.id.btn_view_webp);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				sImageId = sImageId % 5;
				InputStream rawImageStream = getResources().openRawResource(
						sImageArray[sImageId]);
				byte[] data = WebpUtils.streamToBytes(rawImageStream);
				final Bitmap webpBitmap = WebpUtils.webpToBitmap(data);
				imageView.setImageBitmap(webpBitmap);
				sImageId += 1;
			}
		});
	}

}