
from django.db.models import  Count, Avg
from django.shortcuts import render, redirect
from django.db.models import Count

# Create your views here.
from Remote_User.models import ClientPosts_Model,ClientRegister_Model,review_Model


def tweetserverlogin(request):
    if request.method  == "POST":
        admin = request.POST.get('admin')
        password = request.POST.get('password')
        if admin == "Server" and password =="Server":
            return redirect('viewallclients')


    return render(request,'TServer/tweetserverlogin.html')

def viewtreandingquestions(request,chart_type):
    dd = {}
    pos,neu,neg =0,0,0
    poss=None
    topic = ClientPosts_Model.objects.values('ratings').annotate(dcount=Count('ratings')).order_by('-dcount')
    for t in topic:
        topics=t['ratings']
        pos_count=ClientPosts_Model.objects.filter(topics=topics).values('names').annotate(topiccount=Count('ratings'))
        poss=pos_count
        for pp in pos_count:
            senti= pp['names']
            if senti == 'positive':
                pos= pp['topiccount']
            elif senti == 'negative':
                neg = pp['topiccount']
            elif senti == 'nutral':
                neu = pp['topiccount']
        dd[topics]=[pos,neg,neu]
    return render(request,'TServer/viewtreandingquestions.html',{'object':topic,'dd':dd,'chart_type':chart_type})

def Positivereviews(request):

    rtype='Positive'
    #obj = review_Model.objects.all()

    obj = review_Model.objects.all().filter(sanalysis=rtype)

    return render(request,'TServer/Positivereviews.html',{'list_objects': obj})

def Negativereviews(request):

    rtype='Negative'
    #obj = review_Model.objects.all()

    obj = review_Model.objects.all().filter(sanalysis=rtype)

    return render(request,'TServer/Negativereviews.html',{'list_objects': obj})

def Neutralreviews(request):

    rtype='Neutral'
    #obj = review_Model.objects.all()

    obj = review_Model.objects.all().filter(sanalysis=rtype)

    return render(request,'TServer/Neutralreviews.html',{'list_objects': obj})


def viewallclients(request):
    obj=ClientRegister_Model.objects.all()
    return render(request,'TServer/viewallclients.html',{'objects':obj})

def ViewTrendings(request):
    topic = ClientPosts_Model.objects.values('topics').annotate(dcount=Count('topics')).order_by('-dcount')
    return  render(request,'TServer/ViewTrendings.html',{'objects':topic})

def negativechart(request,chart_type):
    dd = {}
    pos, neu, neg = 0, 0, 0
    poss = None
    topic = ClientPosts_Model.objects.values('ratings').annotate(dcount=Count('ratings')).order_by('-dcount')
    for t in topic:
        topics = t['ratings']
        pos_count = ClientPosts_Model.objects.filter(topics=topics).values('names').annotate(topiccount=Count('ratings'))
        poss = pos_count
        for pp in pos_count:
            senti = pp['names']
            if senti == 'positive':
                pos = pp['topiccount']
            elif senti == 'negative':
                neg = pp['topiccount']
            elif senti == 'nutral':
                neu = pp['topiccount']
        dd[topics] = [pos, neg, neu]
    return render(request,'TServer/negativechart.html',{'object':topic,'dd':dd,'chart_type':chart_type})


def charts(request,chart_type):
    chart1 = ClientPosts_Model.objects.values('names').annotate(dcount=Avg('ratings'))
    return render(request,"TServer/charts.html", {'form':chart1, 'chart_type':chart_type})

def dislikeschart(request,dislike_chart):
    charts = ClientPosts_Model.objects.values('names').annotate(dcount=Avg('dislikes'))
    return render(request,"TServer/dislikeschart.html", {'form':charts, 'dislike_chart':dislike_chart})

def Viewalltweets(request):
    chart = ClientPosts_Model.objects.values('names','tgname','ratings','dislikes','uses','sanalysis','tdesc').annotate(dcount=Avg('usefulcounts'))
    return render(request,'TServer/Viewalltweets.html',{'objects':chart})

def viewallpostsreviews(request):
    chart = ClientPosts_Model.objects.values('names', 'tgname', 'ratings', 'dislikes', 'uses', 'sanalysis','tdesc').annotate(dcount=Avg('usefulcounts'))
    return render(request,'TServer/viewallpostsreviews.html',{'objects':chart})

