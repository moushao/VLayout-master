![](http://upload-images.jianshu.io/upload_images/927828-c1c822e4d4a15357.gif?imageMogr2/auto-orient/strip)


#使用方式：

      waterfallAdapter = new VBaseAdapter(mContext)//
                .setData(new ArrayList<WaterCargo>())//
                .setLayout(R.layout.recyc_water)//
                .setHolder(WaterHolder.class)//
                .setLayoutHelper(new StaggeredGridLayoutHelper(2, 8))//
                .setListener(new ItemListener<WaterCargo>() {
                    @Override
                    public void onItemClick(View view, int position, WaterCargo mData) {
                        Toast.makeText(mContext, "瀑布流布局，只卖" + mData.getPrice(), Toast.LENGTH_SHORT).show();
                    }
                }); 



#[简书详细教程]()

#更多交流方式，请加群：541144061

