public class YourService extends KiboRpcService {    @Override    protected void runPlan1(){        api.startMission();        moveTo(11.114, -7.9756, 5.3393, -0.5, -0.5, -0.5, 0.5);        Mat image = api.getMatNavCam();        api.saveMatImage(image, &quot;image.png&quot;);        laser(true);}public void moveTo(double x, double y, double z, double qx, double qy, double qz, double w) {        Point point = new Point(x, y, z);        Quaternion quaternion = new Quaternion((float)qx, (float)qy, (float)qz, (float)w);        Result result = api.moveTo(point, quaternion, false);        final int loop_MAX = 5;        int loop_count = 0;        while (!result.hasSucceeded() && loop_count <= loop_MAX) {            result = api.moveTo(point, quaternion, true);            loop_count++;        }    }    public void laser(boolean shoot) {        if (shoot) {            api.laserControl(true);        }}