package invest.lixinger.company.hotTrDri;

import invest.lixinger.company.fsTypeOfCompany.VO.fsTypeOfCompanyCNResult_RootVO;
import invest.lixinger.company.fundamental.VO.companyFundamentalCNResult_DataVO;
import invest.lixinger.company.fundamental.VO.companyFundamentalCNResult_RootVO;
import invest.lixinger.company.hotTrDri.VO.companyHotTrDriResult_DataVO;
import invest.lixinger.company.hotTrDri.VO.companyHotTrDriResult_RootVO;
import invest.lixinger.ruoyi.entity.codeAndNameVO;
import invest.lixinger.ruoyi.mapper.codeAndNameMapper;
import invest.lixinger.utils.netRequest;
import mybatisNoSpringUtils.mybatisNoSpringUtils;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static invest.lixinger.company.fs.request_fsCompanyCN.requestFsCompanyCN;
import static invest.lixinger.company.fsTypeOfCompany.request_fsTypeOfCompanyCN.requestFsTypeOfCompanyCN;

public class request_companyHotTrDriCN extends mybatisNoSpringUtils {


    public static Map<String, Map<String, String>> requestCompanyHotTrDriCN(fsTypeOfCompanyCNResult_RootVO fsTypeOfCompanyCNResult_rootVO, Map<String, Map<String, String>> doubleFsMap) throws IOException, ParseException {
        InputStream inputStream = request_companyHotTrDriCN.class.getClassLoader().getResourceAsStream("indexReqParam.yml");
        Map indexReqParam = new Yaml().load(inputStream);
        String companyHotTrdriCNURL = (String) indexReqParam.get("companyHotTrdriCNURL");

        String paramJson = getParam_companyHotTrDriCN.getParamCompanyHotTrDriCN(fsTypeOfCompanyCNResult_rootVO);
        String resultJson = netRequest.jsonNetPost(companyHotTrdriCNURL, paramJson);
//        String resultJson = "{\"code\":1,\"message\":\"success\",\"data\":[{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":0.1580055501443618,\"cagr_p_r_fys\":-0.177520192350764,\"cagr_p_r_y1\":-0.18492713996186427,\"cagr_p_r_y10\":0.08400306446090511,\"cagr_p_r_y3\":-0.01293229344875757,\"cagr_p_r_y5\":0.05406220632379721,\"stockCode\":\"600030\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":0.09212072503397395,\"cagr_p_r_fys\":-0.19726494938080774,\"cagr_p_r_y1\":-0.19513379437916378,\"cagr_p_r_y10\":0.027156460402816274,\"cagr_p_r_y20\":0.09461258080878276,\"cagr_p_r_y3\":0.014419157288403595,\"cagr_p_r_y5\":-0.01785017813561729,\"stockCode\":\"600109\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":0.011910439094900083,\"cagr_p_r_fys\":-0.2433376061768351,\"cagr_p_r_y1\":-0.22577484268384063,\"cagr_p_r_y10\":0.01061604947767436,\"cagr_p_r_y20\":0.039052695424329986,\"cagr_p_r_y3\":-0.034822674178863644,\"cagr_p_r_y5\":-0.023764090447503605,\"stockCode\":\"600369\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":0.0866954749820592,\"cagr_p_r_fys\":-0.24138293953586354,\"cagr_p_r_y1\":-0.23889974130193825,\"cagr_p_r_y10\":0.015843723242802144,\"cagr_p_r_y20\":0.10451385458149764,\"cagr_p_r_y3\":-0.13329262122411667,\"cagr_p_r_y5\":-0.05661544654512973,\"stockCode\":\"600837\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.139042800425779,\"cagr_p_r_fys\":-0.10680964376824054,\"cagr_p_r_y1\":-0.10349539383788131,\"cagr_p_r_y3\":-0.04870249998949061,\"cagr_p_r_y5\":-0.05404565545607465,\"stockCode\":\"600909\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.249822098282388,\"cagr_p_r_fys\":-0.3239856125988212,\"cagr_p_r_y1\":-0.3653612577787424,\"stockCode\":\"600918\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.08218711433020187,\"cagr_p_r_fys\":-0.3412649296945999,\"cagr_p_r_y1\":-0.40576775175632807,\"cagr_p_r_y3\":-0.0030215392673405006,\"cagr_p_r_y5\":-0.06574411266172053,\"stockCode\":\"600958\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.005033668451055351,\"cagr_p_r_fys\":-0.20154084111599546,\"cagr_p_r_y1\":-0.21532270855775715,\"cagr_p_r_y10\":0.0869307284967582,\"cagr_p_r_y3\":0.030382906148688216,\"cagr_p_r_y5\":0.025452935295144252,\"stockCode\":\"600999\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":0.19494011452608917,\"cagr_p_r_fys\":-0.1354772292384231,\"cagr_p_r_y1\":-0.1676336061627346,\"cagr_p_r_y3\":-0.017126719689878334,\"stockCode\":\"601066\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.101172492926624,\"cagr_p_r_fys\":-0.18597560975609773,\"cagr_p_r_y1\":-0.1682242990654207,\"cagr_p_r_y10\":0.03282303939448927,\"cagr_p_r_y3\":-0.095653865725282,\"cagr_p_r_y5\":-0.06498728836207102,\"stockCode\":\"601099\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.16335505328124578,\"cagr_p_r_fys\":-0.26367786893462164,\"cagr_p_r_y1\":-0.2728328510260206,\"cagr_p_r_y3\":-0.06076865473400972,\"cagr_p_r_y5\":-0.12939828376951001,\"stockCode\":\"601108\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.17144029367674118,\"cagr_p_r_fys\":-0.2727044025157227,\"cagr_p_r_y1\":-0.2727044025157228,\"cagr_p_r_y3\":-0.17439407747716917,\"stockCode\":\"601162\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.11619661911917112,\"cagr_p_r_fys\":-0.2879675408426484,\"cagr_p_r_y1\":-0.2958386479591837,\"cagr_p_r_y3\":-0.09519820056449368,\"cagr_p_r_y5\":-0.11216287874795461,\"stockCode\":\"601198\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.07668543714226062,\"cagr_p_r_fys\":-0.1740466430656472,\"cagr_p_r_y1\":-0.152734773190621,\"cagr_p_r_y3\":-0.04836158341113894,\"cagr_p_r_y5\":-0.031057228888461075,\"stockCode\":\"601211\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.1051565980296203,\"cagr_p_r_fys\":-0.3199277873998706,\"cagr_p_r_y1\":-0.30236998500916157,\"cagr_p_r_y3\":-0.18563417120721704,\"stockCode\":\"601236\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.13457368829836192,\"cagr_p_r_fys\":-0.2363574186095997,\"cagr_p_r_y1\":-0.22691029389136796,\"cagr_p_r_y3\":-0.09102691320420975,\"cagr_p_r_y5\":-0.0895955578639488,\"stockCode\":\"601375\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":0.01473072463709002,\"cagr_p_r_fys\":-0.3717039539407957,\"cagr_p_r_y1\":-0.38599753362364597,\"cagr_p_r_y10\":0.036667706113406195,\"cagr_p_r_y3\":-0.012190195770602319,\"cagr_p_r_y5\":-0.01968222134627262,\"stockCode\":\"601377\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.10656566326180628,\"cagr_p_r_fys\":-0.15264738437151204,\"cagr_p_r_y1\":-0.17335781841271103,\"stockCode\":\"601456\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":0.021286738979613862,\"cagr_p_r_fys\":-0.21857706611234706,\"cagr_p_r_y1\":-0.1893001491684958,\"cagr_p_r_y10\":0.02368718838787931,\"cagr_p_r_y3\":-0.022783181967186095,\"cagr_p_r_y5\":-0.02809395301843054,\"stockCode\":\"601555\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.016703993369474812,\"cagr_p_r_fys\":-0.23714764884215933,\"cagr_p_r_y1\":-0.22046848351189563,\"cagr_p_r_y10\":0.06148851839972447,\"cagr_p_r_y3\":-0.09655522701012909,\"cagr_p_r_y5\":-0.0433382248848847,\"stockCode\":\"601688\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.2285252883835175,\"cagr_p_r_fys\":-0.1739002791720301,\"cagr_p_r_y1\":-0.22191587919214328,\"stockCode\":\"601696\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.023465811315587892,\"cagr_p_r_fys\":0.058489139795235845,\"cagr_p_r_y1\":0.042430267621561546,\"cagr_p_r_y10\":0.03311249653045745,\"cagr_p_r_y3\":0.09394072671648268,\"cagr_p_r_y5\":0.028616006194463584,\"stockCode\":\"601788\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.06906585240339735,\"cagr_p_r_fys\":-0.2037505945235879,\"cagr_p_r_y1\":-0.23564696546401231,\"cagr_p_r_y3\":0.04990058986980661,\"cagr_p_r_y5\":-0.07311208251781143,\"stockCode\":\"601878\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.017813556824331056,\"cagr_p_r_fys\":-0.0917603392463694,\"cagr_p_r_y1\":-0.06930386411784561,\"cagr_p_r_y3\":-0.020738063949571672,\"cagr_p_r_y5\":-0.005304917029691714,\"stockCode\":\"601881\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":0.015347238461986601,\"cagr_p_r_fys\":-0.17484600547536122,\"cagr_p_r_y1\":-0.18214825321451722,\"cagr_p_r_y10\":0.04921813212508197,\"cagr_p_r_y3\":-0.022761104160430867,\"cagr_p_r_y5\":-0.014608030909451175,\"stockCode\":\"601901\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.003788081440269764,\"cagr_p_r_fys\":-0.16779967072069646,\"cagr_p_r_y1\":-0.1810223174619764,\"cagr_p_r_y3\":-0.032573768534660874,\"stockCode\":\"601990\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":0.008715812439574977,\"cagr_p_r_fys\":-0.20458352053003126,\"cagr_p_r_y1\":-0.25842802836256784,\"stockCode\":\"601995\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.28640693659322347,\"cagr_p_r_fys\":-0.2953238151197659,\"cagr_p_r_y1\":-0.30856195154092647,\"cagr_p_r_y3\":-0.30501327519970545,\"stockCode\":\"603093\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.1276875465322398,\"cagr_p_r_fys\":-0.1790986180904518,\"cagr_p_r_y1\":-0.1917278701198294,\"cagr_p_r_y3\":-0.041000485376758156,\"cagr_p_r_y5\":-0.03634856319652502,\"stockCode\":\"000166\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":0.040764476057302046,\"cagr_p_r_fys\":-0.20976755267879355,\"cagr_p_r_y1\":-0.23249547704865126,\"cagr_p_r_y10\":0.0015461748185323643,\"cagr_p_r_y20\":0.014056843838001098,\"cagr_p_r_y3\":-0.05268004631834977,\"cagr_p_r_y5\":-0.04165656273856211,\"stockCode\":\"000686\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":0.08023219583084895,\"cagr_p_r_fys\":-0.14036799481697448,\"cagr_p_r_y1\":-0.15957764856408063,\"cagr_p_r_y10\":0.09811511713949872,\"cagr_p_r_y20\":0.09739071765541674,\"cagr_p_r_y3\":-0.012970438602193046,\"cagr_p_r_y5\":-0.05127292163568231,\"stockCode\":\"000712\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":0.006597069004127487,\"cagr_p_r_fys\":-0.09922077922077999,\"cagr_p_r_y1\":-0.08496042216358901,\"cagr_p_r_y10\":0.028861469714070775,\"cagr_p_r_y20\":0.0525549655115356,\"cagr_p_r_y3\":-0.018704837389457607,\"cagr_p_r_y5\":-0.053376595254855275,\"stockCode\":\"000728\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":0.03318091695648073,\"cagr_p_r_fys\":-0.15678268968355413,\"cagr_p_r_y1\":-0.15058256240181556,\"cagr_p_r_y10\":-0.030342928355360343,\"cagr_p_r_y20\":0.056108100265788385,\"cagr_p_r_y3\":-0.07485029586560832,\"cagr_p_r_y5\":-0.04889778302001291,\"stockCode\":\"000750\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":0.09919743418203875,\"cagr_p_r_fys\":-0.3378705575881118,\"cagr_p_r_y1\":-0.3599935932032887,\"cagr_p_r_y10\":0.03842907670207052,\"cagr_p_r_y20\":0.08708605541787673,\"cagr_p_r_y3\":0.06465817850041078,\"cagr_p_r_y5\":0.012096983088869306,\"stockCode\":\"000776\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":0.04396702256732765,\"cagr_p_r_fys\":-0.22854453666466867,\"cagr_p_r_y1\":-0.22027155582461144,\"cagr_p_r_y10\":0.05178424769191681,\"cagr_p_r_y20\":0.07543014366081291,\"cagr_p_r_y3\":-0.026420280083145897,\"cagr_p_r_y5\":-0.05560209063488297,\"stockCode\":\"000783\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.06146000353043146,\"cagr_p_r_fys\":-0.1442623392001703,\"cagr_p_r_y1\":-0.1390444266343177,\"cagr_p_r_y10\":-0.0061614795388403865,\"cagr_p_r_y3\":-0.10895951306497942,\"cagr_p_r_y5\":-0.0954329908270225,\"stockCode\":\"002500\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":0.010774475621779134,\"cagr_p_r_fys\":-0.20032006850258144,\"cagr_p_r_y1\":-0.20719692295034786,\"cagr_p_r_y3\":-0.10514755875208082,\"cagr_p_r_y5\":-0.1195146825412382,\"cagr_p_r_y10\":0.028671893420046057,\"stockCode\":\"002673\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.08344509472208517,\"cagr_p_r_fys\":-0.16524381198417937,\"cagr_p_r_y1\":-0.1519468107591485,\"cagr_p_r_y3\":-0.058016429923588464,\"cagr_p_r_y5\":-0.02017420262748193,\"stockCode\":\"002736\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.13335495117648843,\"cagr_p_r_fys\":-0.1983463695131974,\"cagr_p_r_y1\":-0.19394167923579742,\"cagr_p_r_y3\":-0.11290437544507226,\"cagr_p_r_y5\":-0.09244907434661731,\"stockCode\":\"002797\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.14490797757382068,\"cagr_p_r_fys\":-0.16502492340055808,\"cagr_p_r_y1\":-0.14771974046585468,\"cagr_p_r_y3\":-0.057021640781603766,\"stockCode\":\"002926\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.0983170773857136,\"cagr_p_r_fys\":-0.3262845262845261,\"cagr_p_r_y1\":-0.3640950885848847,\"cagr_p_r_y3\":-0.1315043332921586,\"stockCode\":\"002939\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":0.0909907296530239,\"cagr_p_r_fys\":0.02948173920141106,\"cagr_p_r_y1\":-0.056826253689384765,\"cagr_p_r_y3\":-0.005959345720733533,\"stockCode\":\"002945\"},{\"last_update_date\":\"2022-12-16T00:00:00+08:00\",\"cagr_p_r_fs\":-0.24478383214592403,\"cagr_p_r_fys\":-0.4152963487529102,\"cagr_p_r_y1\":-0.43766206218859127,\"cagr_p_r_y3\":-0.2916063162322686,\"stockCode\":\"002961\"}]}";
        companyHotTrDriResult_RootVO resultObj = (companyHotTrDriResult_RootVO) getResult_companyHotTrDriCN.getResultCompanyHotTrDriCN(resultJson);
        return calculateTrDri(resultObj, doubleFsMap);
    }

    public static Map<String, Map<String, String>> calculateTrDri(companyHotTrDriResult_RootVO resultObj, Map<String, Map<String, String>> doubleFsMap) throws IOException, ParseException {
        List<companyHotTrDriResult_DataVO> voList = resultObj.getData();
        DecimalFormat df = new DecimalFormat("0.00%");
        Map<String, Map<String, String>> doubleFundMap = new HashMap<>();

        for (int i = 0; i < voList.size(); i++) {
            companyHotTrDriResult_DataVO vo = voList.get(i);
            Map<String, String> mapTemp = doubleFsMap.get(vo.getStockCode());
            mapTemp.put("今年收益率",df.format(vo.getCagr_p_r_fys()));
            mapTemp.put("近一年收益率",df.format(vo.getCagr_p_r_fys()));
            mapTemp.put("近三年收益率",df.format(vo.getCagr_p_r_fys()));
            mapTemp.put("近五年收益率",df.format(vo.getCagr_p_r_fys()));
            doubleFundMap.put(vo.getStockCode(), mapTemp);

        }

        return doubleFundMap;
    }

    @Test
    public void test() throws IOException, ParseException {
        fsTypeOfCompanyCNResult_RootVO fsTypeOfCompanyCNResult_rootVO = requestFsTypeOfCompanyCN();
        codeAndNameMapper codeAndNameMapper = session.getMapper(codeAndNameMapper.class);
        List<codeAndNameVO> codeAndNameList = codeAndNameMapper.findAll();
        Map<String, Map<String, String>> doubleFsMap = requestFsCompanyCN(fsTypeOfCompanyCNResult_rootVO, codeAndNameList);
        requestCompanyHotTrDriCN(fsTypeOfCompanyCNResult_rootVO, doubleFsMap);
    }

    public request_companyHotTrDriCN() throws FileNotFoundException {
    }
}