<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;

class ListController extends AbstractController
{
    #[Route('/list', name: 'list')]
    public function index(Request $request): Response
    {
        $companies = [
            'Apple' => '$1.16 trillion USD',
            'Samsung' => '$298.68 billon USD',
            'Microsoft' => '$1.10 trillion USD',
            'Alphabet' => '$878.48 billon USD',
            'Intel Corporation' => '$245.82 billon USD',
            'IBM' => '$120.03 billon USD',
            'Facebook' => '$552.39 billon USD',
            'Hon Hai Precision' => '$38.72 billon USD',
            'Tencent' => '$3.02 trillion USD',
            'Oracle' => '$180.54 billon USD'
        ];

        return $this->render('list/index.html.twig', [
            'companies' => $companies
        ]);
    }
}
