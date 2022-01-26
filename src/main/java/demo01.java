import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.streaming.api.java.JavaDStream;

public class demo01 {
    public static void main(String[] args){
        String textFile = "C:\\Users\\Jimmy\\Desktop\\app.2022-01-26.log";
        SparkConf conf= new SparkConf().setMaster("local[*]").setAppName("MyApp");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("WARN");
        JavaRDD<String> log = sc.textFile(textFile).cache();
        long nums = log.count();
        JavaRDD<Integer> size = log.map(s -> s.length());
    }
}
