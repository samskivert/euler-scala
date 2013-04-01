#!/usr/bin/perl -w

my $number = shift or die "Usage: $0 N\n";
my $url = "http://projecteuler.net/index.php";
printf("---\n");
printf("layout: post\n");
printf("title: \"Euler %d\"\n", $number);
printf("---\n");
printf("[Problem %03d]($url?section=problems&id=%d)\n", $number, $number);
my $giturl = "http://github.com/samskivert/euler-scala/raw/master";
printf("([source]($giturl/Euler%03d.scala)):\n\n", $number);
print("{% highlight scala %}\n");
open(CODE, "Euler$number.scala") or die "Can't read Euler$number.scala: $!\n";
while (<CODE>) {
    # $_ =~ s#<#\&lt;#g;
    # $_ =~ s#EulerApp#<a href="/code/euler/EulerApp.scala">EulerApp</a>#g;
    print $_;
}
# print(`sed '' Euler$number.scala`);
print("{% endhighlight %}\n\n");
print("COMMENTS\n");
