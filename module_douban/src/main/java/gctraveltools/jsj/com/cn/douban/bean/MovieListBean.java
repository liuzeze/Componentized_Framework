package gctraveltools.jsj.com.cn.douban.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/1/3	14:39	    刘泽			    新增 类
 * 2018/1/3	14:39	    刘泽			    增加yyy属性
 */

public class MovieListBean implements Serializable {


    /**
     * count : 20
     * start : 0
     * total : 24
     * subjects : [{"rating":{"max":10,"average":6.2,"stars":"30","min":0},"genres":["喜剧","爱情"],
     * "title":"前任3：再见前任","casts":[{"alt":"https://movie.douban.com/celebrity/1275667/",
     * "avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg",
     * "large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg",
     * "medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg"},
     * "name":"韩庚","id":"1275667"},{"alt":"https://movie.douban.com/celebrity/1275564/",
     * "avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1366015827.84.jpg",
     * "large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1366015827.84.jpg",
     * "medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1366015827.84.jpg"},
     * "name":"郑恺","id":"1275564"},{"alt":"https://movie.douban.com/celebrity/1342252/",
     * "avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1408089064.98.jpg"
     * ,"large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1408089064.98.jpg",
     * "medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1408089064.98.jpg"},
     * "name":"于文文","id":"1342252"}],"collect_count":24446,"original_title":"前任3：再见前任",
     * "subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1332171/",
     * "avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg"},"name":"田羽生","id":"1332171"}],"year":"2017","images":{"small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508926717.jpg","large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508926717.jpg","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508926717.jpg"},"alt":"https://movie.douban.com/subject/26662193/","id":"26662193"},{"rating":{"max":10,"average":7.8,"stars":"40","min":0},"genres":["剧情","历史","战争"],"title":"芳华","casts":[{"alt":"https://movie.douban.com/celebrity/1276105/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1403053084.22.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1403053084.22.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1403053084.22.jpg"},"name":"黄轩","id":"1276105"},{"alt":"https://movie.douban.com/celebrity/1366978/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512871367.97.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512871367.97.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512871367.97.jpg"},"name":"苗苗","id":"1366978"},{"alt":"https://movie.douban.com/celebrity/1357009/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1504775118.88.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1504775118.88.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1504775118.88.jpg"},"name":"钟楚曦","id":"1357009"}],"collect_count":257376,"original_title":"芳华","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1274255/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45667.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45667.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45667.jpg"},"name":"冯小刚","id":"1274255"}],"year":"2017","images":{"small":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2507227732.jpg","large":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2507227732.jpg","medium":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2507227732.jpg"},"alt":"https://movie.douban.com/subject/26862829/","id":"26862829"},{"rating":{"max":10,"average":4.8,"stars":"25","min":0},"genres":["喜剧"],"title":"妖铃铃","casts":[{"alt":"https://movie.douban.com/celebrity/1127819/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45539.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45539.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45539.jpg"},"name":"吴君如","id":"1127819"},{"alt":"https://movie.douban.com/celebrity/1325700/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1356510694.28.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1356510694.28.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1356510694.28.jpg"},"name":"沈腾","id":"1325700"},{"alt":"https://movie.douban.com/celebrity/1317663/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p40756.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p40756.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p40756.jpg"},"name":"岳云鹏","id":"1317663"}],"collect_count":23293,"original_title":"妖铃铃","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1127819/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45539.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45539.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45539.jpg"},"name":"吴君如","id":"1127819"}],"year":"2017","images":{"small":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2506825662.jpg","large":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2506825662.jpg","medium":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2506825662.jpg"},"alt":"https://movie.douban.com/subject/26966580/","id":"26966580"},{"rating":{"max":10,"average":6.9,"stars":"35","min":0},"genres":["剧情","悬疑","奇幻"],"title":"妖猫传","casts":[{"alt":"https://movie.douban.com/celebrity/1276105/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1403053084.22.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1403053084.22.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1403053084.22.jpg"},"name":"黄轩","id":"1276105"},{"alt":"https://movie.douban.com/celebrity/1315737/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p50940.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p50940.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p50940.jpg"},"name":"染谷将太","id":"1315737"},{"alt":"https://movie.douban.com/celebrity/1274494/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1510497293.38.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1510497293.38.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1510497293.38.jpg"},"name":"张雨绮","id":"1274494"}],"collect_count":178526,"original_title":"妖猫传","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1023040/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.jpg"},"name":"陈凯歌","id":"1023040"}],"year":"2017","images":{"small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2507024497.jpg","large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2507024497.jpg","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2507024497.jpg"},"alt":"https://movie.douban.com/subject/5350027/","id":"5350027"},{"rating":{"max":10,"average":6.2,"stars":"30","min":0},"genres":["喜剧","爱情","奇幻"],"title":"二代妖精之今生有幸","casts":[{"alt":"https://movie.douban.com/celebrity/1275721/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36925.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36925.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36925.jpg"},"name":"冯绍峰","id":"1275721"},{"alt":"https://movie.douban.com/celebrity/1049732/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513067217.13.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513067217.13.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513067217.13.jpg"},"name":"刘亦菲","id":"1049732"},{"alt":"https://movie.douban.com/celebrity/1275178/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p37722.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p37722.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p37722.jpg"},"name":"李光洁","id":"1275178"}],"collect_count":23704,"original_title":"二代妖精之今生有幸","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1331182/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1426816047.48.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1426816047.48.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1426816047.48.jpg"},"name":"肖洋","id":"1331182"}],"year":"2017","images":{"small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2507022339.jpg","large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2507022339.jpg","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2507022339.jpg"},"alt":"https://movie.douban.com/subject/26797419/","id":"26797419"},{"rating":{"max":10,"average":5.4,"stars":"30","min":0},"genres":["剧情","奇幻"],"title":"解忧杂货店","casts":[{"alt":"https://movie.douban.com/celebrity/1339594/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1503377320.23.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1503377320.23.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1503377320.23.jpg"},"name":"王俊凯","id":"1339594"},{"alt":"https://movie.douban.com/celebrity/1325127/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492095415.48.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492095415.48.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492095415.48.jpg"},"name":"迪丽热巴","id":"1325127"},{"alt":"https://movie.douban.com/celebrity/1330472/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1385100761.5.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1385100761.5.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1385100761.5.jpg"},"name":"董子健","id":"1330472"}],"collect_count":27949,"original_title":"解忧杂货店","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1316056/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34888.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34888.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34888.jpg"},"name":"韩杰","id":"1316056"}],"year":"2017","images":{"small":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2503544593.jpg","large":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2503544593.jpg","medium":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2503544593.jpg"},"alt":"https://movie.douban.com/subject/26654146/","id":"26654146"},{"rating":{"max":10,"average":9.1,"stars":"45","min":0},"genres":["喜剧","动画","冒险"],"title":"寻梦环游记","casts":[{"alt":"https://movie.douban.com/celebrity/1370411/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1489594517.9.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1489594517.9.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1489594517.9.jpg"},"name":"安东尼·冈萨雷斯","id":"1370411"},{"alt":"https://movie.douban.com/celebrity/1041009/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1510634028.69.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1510634028.69.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1510634028.69.jpg"},"name":"盖尔·加西亚·贝纳尔","id":"1041009"},{"alt":"https://movie.douban.com/celebrity/1036383/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1416762292.89.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1416762292.89.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1416762292.89.jpg"},"name":"本杰明·布拉特","id":"1036383"}],"collect_count":343450,"original_title":"Coco","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1022678/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13830.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13830.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13830.jpg"},"name":"李·昂克里奇","id":"1022678"},{"alt":"https://movie.douban.com/celebrity/1370425/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1497195148.21.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1497195148.21.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1497195148.21.jpg"},"name":"阿德里安·莫利纳","id":"1370425"}],"year":"2017","images":{"small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2503997609.jpg","large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2503997609.jpg","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2503997609.jpg"},"alt":"https://movie.douban.com/subject/20495023/","id":"20495023"},{"rating":{"max":10,"average":6.1,"stars":"30","min":0},"genres":["动作","犯罪","悬疑"],"title":"心理罪之城市之光","casts":[{"alt":"https://movie.douban.com/celebrity/1274235/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p805.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p805.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p805.jpg"},"name":"邓超","id":"1274235"},{"alt":"https://movie.douban.com/celebrity/1259866/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21006.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21006.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21006.jpg"},"name":"阮经天","id":"1259866"},{"alt":"https://movie.douban.com/celebrity/1274533/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p35797.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p35797.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p35797.jpg"},"name":"刘诗诗","id":"1274533"}],"collect_count":33376,"original_title":"心理罪之城市之光","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1317195/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p38956.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p38956.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p38956.jpg"},"name":"徐纪周","id":"1317195"}],"year":"2017","images":{"small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506228506.jpg","large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506228506.jpg","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506228506.jpg"},"alt":"https://movie.douban.com/subject/26774722/","id":"26774722"},{"rating":{"max":10,"average":8.3,"stars":"45","min":0},"genres":["喜剧","动画","家庭"],"title":"帕丁顿熊2","casts":[{"alt":"https://movie.douban.com/celebrity/1025149/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1397997449.99.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1397997449.99.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1397997449.99.jpg"},"name":"本·卫肖","id":"1025149"},{"alt":"https://movie.douban.com/celebrity/1003493/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1871.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1871.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1871.jpg"},"name":"休·格兰特","id":"1003493"},{"alt":"https://movie.douban.com/celebrity/1041224/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1416053013.86.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1416053013.86.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1416053013.86.jpg"},"name":"休·博内威利","id":"1041224"}],"collect_count":57305,"original_title":"Paddington 2","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1313689/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1425285993.52.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1425285993.52.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1425285993.52.jpg"},"name":"保罗·金","id":"1313689"}],"year":"2017","images":{"small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506466229.jpg","large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506466229.jpg","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506466229.jpg"},"alt":"https://movie.douban.com/subject/26340419/","id":"26340419"},{"rating":{"max":10,"average":5,"stars":"25","min":0},"genres":["剧情","动作","科幻"],"title":"机器之血","casts":[{"alt":"https://movie.douban.com/celebrity/1054531/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p694.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p694.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p694.jpg"},"name":"成龙","id":"1054531"},{"alt":"https://movie.douban.com/celebrity/1274317/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3083.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3083.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3083.jpg"},"name":"罗志祥","id":"1274317"},{"alt":"https://movie.douban.com/celebrity/1336314/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1499104651.08.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1499104651.08.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1499104651.08.jpg"},"name":"欧阳娜娜","id":"1336314"}],"collect_count":10811,"original_title":"机器之血","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1324053/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495169894.72.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495169894.72.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495169894.72.jpg"},"name":"张立嘉","id":"1324053"}],"year":"2017","images":{"small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2505785547.jpg","large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2505785547.jpg","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2505785547.jpg"},"alt":"https://movie.douban.com/subject/26729868/","id":"26729868"},{"rating":{"max":10,"average":8.6,"stars":"45","min":0},"genres":["剧情","传记","动画"],"title":"至爱梵高·星空之谜","casts":[{"alt":"https://movie.douban.com/celebrity/1314461/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p43221.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p43221.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p43221.jpg"},"name":"道格拉斯·布斯","id":"1314461"},{"alt":"https://movie.douban.com/celebrity/1376200/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1498554583.31.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1498554583.31.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1498554583.31.jpg"},"name":"罗伯特·古拉奇克","id":"1376200"},{"alt":"https://movie.douban.com/celebrity/1275043/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360941730.7.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360941730.7.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360941730.7.jpg"},"name":"埃莉诺·汤姆林森","id":"1275043"}],"collect_count":85077,"original_title":"Loving Vincent","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1326282/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1393488180.49.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1393488180.49.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1393488180.49.jpg"},"name":"多洛塔·科别拉","id":"1326282"},{"alt":"https://movie.douban.com/celebrity/1306202/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1498554460.64.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1498554460.64.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1498554460.64.jpg"},"name":"休·韦尔什曼","id":"1306202"}],"year":"2017","images":{"small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506935748.jpg","large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506935748.jpg","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506935748.jpg"},"alt":"https://movie.douban.com/subject/25837262/","id":"25837262"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["儿童","动画","奇幻"],"title":"小猫巴克里","casts":[{"alt":"https://movie.douban.com/celebrity/1386018/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"林佑俽","id":"1386018"},{"alt":"https://movie.douban.com/celebrity/1386019/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"郭馨雅","id":"1386019"},{"alt":"https://movie.douban.com/celebrity/1275593/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p35136.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p35136.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p35136.jpg"},"name":"屈中恒","id":"1275593"}],"collect_count":339,"original_title":"小貓巴克里","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1372804/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512959486.04.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512959486.04.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512959486.04.jpg"},"name":"邱立伟","id":"1372804"}],"year":"2017","images":{"small":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508948724.jpg","large":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508948724.jpg","medium":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508948724.jpg"},"alt":"https://movie.douban.com/subject/26887161/","id":"26887161"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["儿童","动画","奇幻"],"title":"咕噜咕噜美人鱼2","casts":[{"alt":"https://movie.douban.com/celebrity/1386282/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"丁莹莹","id":"1386282"},{"alt":"https://movie.douban.com/celebrity/1356706/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1481650266.82.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1481650266.82.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1481650266.82.jpg"},"name":"杨进","id":"1356706"},{"alt":"https://movie.douban.com/celebrity/1348773/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"卢瑶","id":"1348773"}],"collect_count":114,"original_title":"咕噜咕噜美人鱼2","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1340240/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483596470.52.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483596470.52.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483596470.52.jpg"},"name":"杨广福","id":"1340240"}],"year":"2017","images":{"small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508071436.jpg","large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508071436.jpg","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508071436.jpg"},"alt":"https://movie.douban.com/subject/27193475/","id":"27193475"},{"rating":{"max":10,"average":4.8,"stars":"25","min":0},"genres":["动作","奇幻"],"title":"奇门遁甲","casts":[{"alt":"https://movie.douban.com/celebrity/1324043/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490342249.11.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490342249.11.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490342249.11.jpg"},"name":"大鹏","id":"1324043"},{"alt":"https://movie.douban.com/celebrity/1315861/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1368598869.24.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1368598869.24.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1368598869.24.jpg"},"name":"倪妮","id":"1315861"},{"alt":"https://movie.douban.com/celebrity/1274292/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10299.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10299.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10299.jpg"},"name":"李治廷","id":"1274292"}],"collect_count":23356,"original_title":"奇门遁甲","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1275026/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p9332.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p9332.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p9332.jpg"},"name":"袁和平","id":"1275026"}],"year":"2017","images":{"small":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2507566212.jpg","large":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2507566212.jpg","medium":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2507566212.jpg"},"alt":"https://movie.douban.com/subject/26661191/","id":"26661191"},{"rating":{"max":10,"average":8.6,"stars":"45","min":0},"genres":["剧情","传记","历史"],"title":"至暗时刻","casts":[{"alt":"https://movie.douban.com/celebrity/1010507/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33896.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33896.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33896.jpg"},"name":"加里·奥德曼","id":"1010507"},{"alt":"https://movie.douban.com/celebrity/1021997/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512573236.06.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512573236.06.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512573236.06.jpg"},"name":"克里斯汀·斯科特·托马斯","id":"1021997"},{"alt":"https://movie.douban.com/celebrity/1318674/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1426508419.1.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1426508419.1.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1426508419.1.jpg"},"name":"莉莉·詹姆斯","id":"1318674"}],"collect_count":51354,"original_title":"Darkest Hour","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1275041/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1424001982.32.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1424001982.32.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1424001982.32.jpg"},"name":"乔·赖特","id":"1275041"}],"year":"2017","images":{"small":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2504277551.jpg","large":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2504277551.jpg","medium":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2504277551.jpg"},"alt":"https://movie.douban.com/subject/26761416/","id":"26761416"},{"rating":{"max":10,"average":5.5,"stars":"30","min":0},"genres":["剧情"],"title":"咖啡风暴","casts":[{"alt":"https://movie.douban.com/celebrity/1083010/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21789.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21789.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21789.jpg"},"name":"恩尼奥·凡塔斯蒂基尼","id":"1083010"},{"alt":"https://movie.douban.com/celebrity/1315585/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1380440677.6.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1380440677.6.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1380440677.6.jpg"},"name":"芦芳生","id":"1315585"},{"alt":"https://movie.douban.com/celebrity/1312976/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p38291.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p38291.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p38291.jpg"},"name":"谭卓","id":"1312976"}],"collect_count":101,"original_title":"Caffè","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1010292/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p24213.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p24213.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p24213.jpg"},"name":"克里斯蒂亚诺·博尔托内","id":"1010292"}],"year":"2016","images":{"small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508258787.jpg","large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508258787.jpg","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508258787.jpg"},"alt":"https://movie.douban.com/subject/26649225/","id":"26649225"},{"rating":{"max":10,"average":6.1,"stars":"30","min":0},"genres":["惊悚","冒险"],"title":"鲨海","casts":[{"alt":"https://movie.douban.com/celebrity/1000013/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p23017.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p23017.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p23017.jpg"},"name":"曼迪·摩尔","id":"1000013"},{"alt":"https://movie.douban.com/celebrity/1232340/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p46657.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p46657.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p46657.jpg"},"name":"克莱尔·霍尔特","id":"1232340"},{"alt":"https://movie.douban.com/celebrity/1050080/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p11804.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p11804.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p11804.jpg"},"name":"克里斯·J.约翰逊","id":"1050080"}],"collect_count":11134,"original_title":"47 Meters Down","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1019388/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1498455992.67.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1498455992.67.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1498455992.67.jpg"},"name":"约翰内斯·罗伯茨","id":"1019388"}],"year":"2016","images":{"small":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2504892832.jpg","large":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2504892832.jpg","medium":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2504892832.jpg"},"alt":"https://movie.douban.com/subject/26845362/","id":"26845362"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["惊悚","恐怖"],"title":"惊魂七夜","casts":[{"alt":"https://movie.douban.com/celebrity/1318068/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512035444.96.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512035444.96.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512035444.96.jpg"},"name":"陈美行","id":"1318068"},{"alt":"https://movie.douban.com/celebrity/1359998/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1500703529.17.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1500703529.17.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1500703529.17.jpg"},"name":"曾帅","id":"1359998"},{"alt":"https://movie.douban.com/celebrity/1364647/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1478846357.88.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1478846357.88.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1478846357.88.jpg"},"name":"濡雪","id":"1364647"}],"collect_count":96,"original_title":"惊魂七夜","subtype":"movie","directors":[{"alt":null,"avatars":null,"name":"喻彬","id":null}],"year":"2016","images":{"small":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508243232.jpg","large":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508243232.jpg","medium":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508243232.jpg"},"alt":"https://movie.douban.com/subject/26923563/","id":"26923563"},{"rating":{"max":10,"average":6.6,"stars":"35","min":0},"genres":["剧情","冒险"],"title":"七十七天","casts":[{"alt":"https://movie.douban.com/celebrity/1274286/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p823.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p823.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p823.jpg"},"name":"江一燕","id":"1274286"},{"alt":"https://movie.douban.com/celebrity/1326525/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509791481.95.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509791481.95.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509791481.95.jpg"},"name":"赵汉唐","id":"1326525"}],"collect_count":15869,"original_title":"七十七天","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1326525/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509791481.95.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509791481.95.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509791481.95.jpg"},"name":"赵汉唐","id":"1326525"}],"year":"2014","images":{"small":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2503551480.jpg","large":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2503551480.jpg","medium":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2503551480.jpg"},"alt":"https://movie.douban.com/subject/26426026/","id":"26426026"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["剧情"],"title":"邹碧华","casts":[{"alt":"https://movie.douban.com/celebrity/1276103/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p29367.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p29367.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p29367.jpg"},"name":"佟瑞欣","id":"1276103"},{"alt":"https://movie.douban.com/celebrity/1313725/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20132.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20132.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20132.jpg"},"name":"王诗槐","id":"1313725"},{"alt":"https://movie.douban.com/celebrity/1314315/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pTI9kXjAMGTwcel_avatar_uploaded1353221024.96.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pTI9kXjAMGTwcel_avatar_uploaded1353221024.96.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pTI9kXjAMGTwcel_avatar_uploaded1353221024.96.jpg"},"name":"刘小锋","id":"1314315"}],"collect_count":161,"original_title":"邹碧华","subtype":"movie","directors":[],"year":"2017","images":{"small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506257419.jpg","large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506257419.jpg","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506257419.jpg"},"alt":"https://movie.douban.com/subject/26866174/","id":"26866174"}]
     * title : 正在上映的电影-北京
     */

    @SerializedName("count")
    private int count;
    @SerializedName("start")
    private int start;
    @SerializedName("total")
    private int total;
    @SerializedName("title")
    private String title;
    @SerializedName("subjects")
    private List<SubjectsEntity> subjects;

    public void setCount(int count) {
        this.count = count;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubjects(List<SubjectsEntity> subjects) {
        this.subjects = subjects;
    }

    public int getCount() {
        return count;
    }

    public int getStart() {
        return start;
    }

    public int getTotal() {
        return total;
    }

    public String getTitle() {
        return title;
    }

    public List<SubjectsEntity> getSubjects() {
        return subjects;
    }

    public static class SubjectsEntity {
        /**
         * rating : {"max":10,"average":6.2,"stars":"30","min":0}
         * genres : ["喜剧","爱情"]
         * title : 前任3：再见前任
         * casts : [{"alt":"https://movie.douban.com/celebrity/1275667/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg"},"name":"韩庚","id":"1275667"},{"alt":"https://movie.douban.com/celebrity/1275564/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1366015827.84.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1366015827.84.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1366015827.84.jpg"},"name":"郑恺","id":"1275564"},{"alt":"https://movie.douban.com/celebrity/1342252/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1408089064.98.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1408089064.98.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1408089064.98.jpg"},"name":"于文文","id":"1342252"}]
         * collect_count : 24446
         * original_title : 前任3：再见前任
         * subtype : movie
         * directors : [{"alt":"https://movie.douban.com/celebrity/1332171/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg"},"name":"田羽生","id":"1332171"}]
         * year : 2017
         * images : {"small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508926717.jpg","large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508926717.jpg","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508926717.jpg"}
         * alt : https://movie.douban.com/subject/26662193/
         * id : 26662193
         */

        @SerializedName("rating")
        private RatingEntity rating;
        @SerializedName("title")
        private String title;
        @SerializedName("collect_count")
        private int collectCount;
        @SerializedName("original_title")
        private String originalTitle;
        @SerializedName("subtype")
        private String subtype;
        @SerializedName("year")
        private String year;
        @SerializedName("images")
        private ImagesEntity images;
        @SerializedName("alt")
        private String alt;
        @SerializedName("id")
        private String id;
        @SerializedName("genres")
        private List<String> genres;
        @SerializedName("casts")
        private List<CastsEntity> casts;
        @SerializedName("directors")
        private List<DirectorsEntity> directors;

        public void setRating(RatingEntity rating) {
            this.rating = rating;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setCollectCount(int collectCount) {
            this.collectCount = collectCount;
        }

        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public void setImages(ImagesEntity images) {
            this.images = images;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public void setCasts(List<CastsEntity> casts) {
            this.casts = casts;
        }

        public void setDirectors(List<DirectorsEntity> directors) {
            this.directors = directors;
        }

        public RatingEntity getRating() {
            return rating;
        }

        public String getTitle() {
            return title;
        }

        public int getCollectCount() {
            return collectCount;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public String getSubtype() {
            return subtype;
        }

        public String getYear() {
            return year;
        }

        public ImagesEntity getImages() {
            return images;
        }

        public String getAlt() {
            return alt;
        }

        public String getId() {
            return id;
        }

        public List<String> getGenres() {
            return genres;
        }

        public List<CastsEntity> getCasts() {
            return casts;
        }

        public List<DirectorsEntity> getDirectors() {
            return directors;
        }

        public static class RatingEntity {
            /**
             * max : 10
             * average : 6.2
             * stars : 30
             * min : 0
             */

            @SerializedName("max")
            private int max;
            @SerializedName("average")
            private double average;
            @SerializedName("stars")
            private String stars;
            @SerializedName("min")
            private int min;

            public void setMax(int max) {
                this.max = max;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public void setMin(int min) {
                this.min = min;
            }

            public int getMax() {
                return max;
            }

            public double getAverage() {
                return average;
            }

            public String getStars() {
                return stars;
            }

            public int getMin() {
                return min;
            }
        }

        public static class ImagesEntity {
            /**
             * small : http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508926717.jpg
             * large : http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508926717.jpg
             * medium : http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508926717.jpg
             */

            @SerializedName("small")
            private String small;
            @SerializedName("large")
            private String large;
            @SerializedName("medium")
            private String medium;

            public void setSmall(String small) {
                this.small = small;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getSmall() {
                return small;
            }

            public String getLarge() {
                return large;
            }

            public String getMedium() {
                return medium;
            }
        }

        public static class CastsEntity {
            /**
             * alt : https://movie.douban.com/celebrity/1275667/
             * avatars : {"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg"}
             * name : 韩庚
             * id : 1275667
             */

            @SerializedName("alt")
            private String alt;
            @SerializedName("avatars")
            private AvatarsEntity avatars;
            @SerializedName("name")
            private String name;
            @SerializedName("id")
            private String id;

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public void setAvatars(AvatarsEntity avatars) {
                this.avatars = avatars;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAlt() {
                return alt;
            }

            public AvatarsEntity getAvatars() {
                return avatars;
            }

            public String getName() {
                return name;
            }

            public String getId() {
                return id;
            }

            public static class AvatarsEntity {
                /**
                 * small : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg
                 * large : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg
                 * medium : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg
                 */

                @SerializedName("small")
                private String small;
                @SerializedName("large")
                private String large;
                @SerializedName("medium")
                private String medium;

                public void setSmall(String small) {
                    this.small = small;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }

                public String getSmall() {
                    return small;
                }

                public String getLarge() {
                    return large;
                }

                public String getMedium() {
                    return medium;
                }
            }
        }

        public static class DirectorsEntity {
            /**
             * alt : https://movie.douban.com/celebrity/1332171/
             * avatars : {"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg"}
             * name : 田羽生
             * id : 1332171
             */

            @SerializedName("alt")
            private String alt;
            @SerializedName("avatars")
            private AvatarsEntity avatars;
            @SerializedName("name")
            private String name;
            @SerializedName("id")
            private String id;

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public void setAvatars(AvatarsEntity avatars) {
                this.avatars = avatars;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAlt() {
                return alt;
            }

            public AvatarsEntity getAvatars() {
                return avatars;
            }

            public String getName() {
                return name;
            }

            public String getId() {
                return id;
            }

            public static class AvatarsEntity {
                /**
                 * small : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg
                 * large : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg
                 * medium : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg
                 */

                @SerializedName("small")
                private String small;
                @SerializedName("large")
                private String large;
                @SerializedName("medium")
                private String medium;

                public void setSmall(String small) {
                    this.small = small;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }

                public String getSmall() {
                    return small;
                }

                public String getLarge() {
                    return large;
                }

                public String getMedium() {
                    return medium;
                }
            }
        }
    }
}
