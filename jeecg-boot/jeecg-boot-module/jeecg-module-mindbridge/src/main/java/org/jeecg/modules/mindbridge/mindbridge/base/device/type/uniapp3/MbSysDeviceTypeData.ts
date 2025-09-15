import { render } from '@/common/renderUtils';
//列表数据
export const columns = [
    {
    title: '类型编码',
    align:"center",
    dataIndex: 'code'
   },
   {
    title: '类型名称',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '类别',
    align:"center",
    dataIndex: 'category_dictText'
   },
   {
    title: '支持的信号/数据通道',
    align:"center",
    dataIndex: 'signalsJson'
   },
   {
    title: '接口能力',
    align:"center",
    dataIndex: 'ifaceJson'
   },
   {
    title: '是否支持远程控制',
    align:"center",
    dataIndex: 'remoteCtrl',
    customRender:({text}) => {
       return render.renderSwitch(text, [{text:'是',value:'1'},{text:'否',value:'0'}])
     },
   },
   {
    title: '安全边界默认值',
    align:"center",
    dataIndex: 'safetyJson'
   },
   {
    title: '扩展属性',
    align:"center",
    dataIndex: 'extraJson'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'status',
    customRender:({text}) => {
       return render.renderSwitch(text, [{text:'是',value:'ACTIVE'},{text:'否',value:'DISABLED'}])
     },
   },
];