git config status.submodulesummary 1;
git config submodule.recurse 1;
git config push.recurseSubmodules check;
git config alias.supdate 'submodule update --remote --merge';
echo "git configured for submodule usage!";
