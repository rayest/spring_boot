#!/usr/bin/env bash

echo "Hello World!"

name="rayest"
echo  ${name}

name="Rayest"
echo ${name}

baiduUrl="www.baidu.com"
# 只读，不可以更改
readonly baiduUrl
# baiduUrl="www.baidu.com.cn"

age=26
echo ${age}
age=27
# 删除变量
unset age
echo $age

# 单引号
id='123'
echo "id:" ${id}

# 双引号，可以内嵌双引号
greeting="Hello, "$name"!"
echo $greeting

city="shanghai big"
# 字符串长度
echo ${#city}
# 从0开始截取2个字符
echo ${city:0:2}

# 数组
cities=(
	南京
	上海
	苏州
	呼和浩特
	北京
	)
echo ${cities[0]}  # 数组第一个元素
echo ${cities[@]} # 数组所有元素
echo ${#cities[*]} # 数组的长度
echo ${#cities[3]} # 数组第3个元素的长度

# 传递参数
echo "Shell 传递参数实例！"
echo "执行的文件名：$0"
echo "第一个参数为：$1"
echo "第二个参数为：$2"
echo "第三个参数为：$3"

# 运算符
result=`expr 5 + 2`
echo $result

a=10
b=20

# 条件判断
if [ $a -eq $b ]
then
    echo "a等于b"
else
    echo "a不等于b"
fi  # 结束：finally

# 条件判断
if [ $a != $b ]
then
    echo "a不等于b"
fi

# 输出日期
echo `date`

number1=10
number2=20

# test
if test $number1 -eq $number2
then
    echo "相等"
else
    echo "不相等"
fi

result=$[a + b]
echo $result

# for 循环
for value in 1 2 3 4 5
do
    echo $value
done

# while
size=6
while(( size<=10 ))
do
    echo $size
    let "size++"
done

# 定义函数
function demoFunction(){
    echo "The first shell function"
}
# 调用函数
demoFunction