# quizpg

+ one activity will have 1 (view)  
+ (view) can be (imageview), (surfaceview)  
+ (groupview) take care to positioned (view)  
+ (view) is different with (surfaceview), (view) is parent of (surfaceview)  
  - if we want to animate (view) use (invalidate)   
  - (surfaceview) use (thread) to draw its will exactly on milisecond  

+ "lovetest233" - show how (animator) translate object <imageview> from x0 -> x1 horizontal
+ "caro" - show how animator animate as (frame) according to time


below class help us draw many drawable object on 1 view

public class ViewLayer extends View {

    private LayerDrawable drawables;

    public ViewLayer(Context context, Bitmap bitmap1, Bitmap bitmap2) {
        super(context);
        Drawable space = new BitmapDrawable(context.getResources(), bitmap1);
        Drawable moon = new BitmapDrawable(context.getResources(), bitmap2);
       // space.setBounds(0,0,300,600);
       // moon.setBounds(0,0,900,600);

        Drawable[] bodies = {space,moon};
        drawables = new LayerDrawable(bodies);
        drawables.setLayerInset(0,0,0,300,600);
        drawables.setLayerInset(1,0,0,900,600);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawables.draw(canvas);
    }
}

layerDrawable inset will help us inset drawable inside another drawable

public class ViewDrawable extends LayerDrawable {


	public static ViewDrawable Create(Context context, Bitmap bitmap)
	{

		Drawable space = new BitmapDrawable(context.getResources(), bitmap);
		Drawable space1 = new BitmapDrawable(context.getResources(), bitmap);
		Drawable[] bodies = {space,space1};
		ViewDrawable myOrrery = new ViewDrawable(bodies);

		myOrrery.setLayerInset(
				0,0,0,0,0);
		myOrrery.setLayerInset(
				1,500,500,400,400);
		return myOrrery;
	}



	private ViewDrawable(Drawable[] bodies)
	{
		super(bodies);
	}

}

Bitmap bitmap = takeBitmap(this,size,"ball");
        ViewDrawable o = ViewDrawable.Create(this,bitmap);
        imageView.setImageDrawable(o);
        imageView.setScaleType(ImageView.ScaleType.FIT_START);
        setContentView(imageView);
        
        
