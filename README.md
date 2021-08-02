8/2/2021
RecyclerView
  RecyclerView makes it easy to efficiently display large sets of data. You supply the data and define how each item looks, and the RecyclerView library dynamically creates the elements when they're needed.
  as the name implies, RV recycles those individual elements, when an item scrolls off the screen, RV  doesn't destroy its view. instead, RV reuse the view for new items that have scrolled onscreen. This reuse vastly improves performance, improving your app's responsiveness and reducing power consumption.
  note: besides being the name of the class, RV is also the name of the library
key classes
  several different classes work together to build your dynamic list
  RV is the viewgroup that contain the views correcponding to your data, its a view itself, so you add RV into your layout the way you would add any other UI element.
  each individual element in the list is defined by a view holder object, when the view holder is created, it doesn't have any data associated with it. when the view holder is created, it doesn't have any data assocuated with it, after the view holder is created, the RV binds it to its data, you define the view holder by extending RV.viewholder

Viewholder describes an item view and metadata about its place within the RV

RV.adapter implementations should subclass viewholder and add fields for caching potentially expensive View.findviewid result
RV adapter implementations nên phân lớp viewholder và thêm fields để trử data
while RV.layoutparam phụ thuộc RVlayoutmanager
viewholders phụ thuộc adapter

Adapters provide a binding from an app-specific data set to views that are displayed within a RV
Adapter cung cấp sự ràng buộc từ 1 bộ data của app cái sẻ hiển thị trong RV

  
PullToRefeshView
  
ProgressWheel
  
Drawer
  
VerticalRecyclerViewFastScroller
  
