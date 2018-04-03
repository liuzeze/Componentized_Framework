package gctraveltools.jsj.com.cn.demomodule.coordinator.behavior;


import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/4/3	14:46	    刘泽			    新增 类
 * 2018/4/3	14:46	    刘泽			    增加yyy属性
 */
public class MySelfBehavior extends CoordinatorLayout.Behavior<View> {

    private static final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();


    private int sinceDirectionChange;
    private int mTranslationY = 0;


    public MySelfBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /* @Override
     public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
         return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
     }

     @Override
     public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
         if (dy > 0 && sinceDirectionChange < 0 || dy < 0 && sinceDirectionChange > 0) {
             child.animate().cancel();
             sinceDirectionChange = 0;
         }
         sinceDirectionChange += dy;
         //  System.out.println("sinceDirectionChange---------"+sinceDirectionChange+"childHeight+++++++++++"+child.getHeight());
         if (sinceDirectionChange > child.getHeight() && child.getVisibility() == View.VISIBLE) {
             hide(child);
         } else if (sinceDirectionChange < 0 && child.getVisibility() == View.GONE) {
             show(child);
         }
     }


     private void hide(final View view) {
         ViewPropertyAnimator animator = view.animate().translationY(view.getHeight()).setInterpolator(INTERPOLATOR).setDuration(500);
         animator.setListener(new Animator.AnimatorListener() {
             @Override
             public void onAnimationStart(Animator animator) {

             }

             @Override
             public void onAnimationEnd(Animator animator) {
                 view.setVisibility(View.INVISIBLE);
             }

             @Override
             public void onAnimationCancel(Animator animator) {
                 show(view);
             }

             @Override
             public void onAnimationRepeat(Animator animator) {

             }
         });
         animator.start();
     }


     private void show(final View view) {
         ViewPropertyAnimator animator = view.animate().translationY(0).setInterpolator(INTERPOLATOR).setDuration(500);
         animator.setListener(new Animator.AnimatorListener() {
             @Override
             public void onAnimationStart(Animator animator) {

             }

             @Override
             public void onAnimationEnd(Animator animator) {
                 view.setVisibility(View.VISIBLE);
             }

             @Override
             public void onAnimationCancel(Animator animator) {
                 hide(view);
             }

             @Override
             public void onAnimationRepeat(Animator animator) {

             }
         });
         animator.start();

     }*/
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        int measuredHeight = child.getMeasuredHeight();
        int top = dependency.getTop();
        System.out.println("top===" + top + "mTranslationY===="+mTranslationY);
        if (top < mTranslationY) {//上滑
            child.animate().translationY(measuredHeight).setDuration(300).start();
        } else {//下滑
            child.animate().translationY(0).setDuration(300).start();
        }
        return true;
    }

}