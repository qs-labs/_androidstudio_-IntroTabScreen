package qslabs.com.introtabscreen;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by QSLabs on 4/16/2018.
 */

public class IntroPageTransformer implements ViewPager.PageTransformer {
    /**
     * The animations used in transformPage follow the
     * animation suggestions made in
     * https://gist.github.com/MizzleDK/4e16582b259134b55d7c#file-intropagetransformer-java.
     * The are many more animations that can be applied --> be creative!
     */

    /**
     * argument 'page' will always represent a page attached to the IntroPageTransformer;
     * thus, it will always be a page displayed by the ViewPager.
     * argument 'position' represents the position of the View 'page' relative to center
     * position of the ViewPager; thus, 'position' = 0 when the page is centered, 'position'
     * = 1 when the page is one page distance to the right, and 'position' = -1 when the page
     * is one page distance to the left.
     */

    @Override
    public void transformPage(View page, float position) {
        int pagePosition = (int) page.getTag(); // returning page identifier from fragment, allowing for page-specific transformations

        int pageWidth = page.getWidth();
        float pageWidthTimesPosition = pageWidth * position;
        int pageHeight = page.getHeight();
        float pageHeightTimesPosition = pageHeight * position;
        float absPosition = Math.abs(position);

        if (position <= -1.0f || position >= 1.0f) {
            // The page is out of view
        } else if (position == 0.0f) {
            // The page has been selected, but not scrolled
        } else { // the page has been selected and scrolled within the upper and lower limits of 'position'
            View text = page.findViewById(R.id.text);
            View image = page.findViewById(R.id.image);

            text.setAlpha(1.0f - absPosition); // increasing transparency as 'page' View deviates from position = 0, both left or right
            image.setAlpha(1.0f - absPosition); // increasing transparency as 'page' View deviates from position = 0, both left or right

            /**
             * setTranslationX (API 11) sets the horizontal location of the view relative to the view's
             * left position relative to the parent. setTranslationY (API 11) and setTranslationZ (API 21) also exist.
             * Changing the X-orientation of the image to equal 1.5(∆position) IN THE OPPOSITE DIRECTION.
             */
            image.setTranslationX(-pageWidthTimesPosition * 1.5f);

            if (position < 0) { // if the user is swiping to the right (moving page left)
            } else { // if the user is swiping to the left (moving page right)
            }
        }
    }
}
